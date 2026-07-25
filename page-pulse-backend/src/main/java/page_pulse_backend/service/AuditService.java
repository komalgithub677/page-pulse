package page_pulse_backend.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import page_pulse_backend.dto.AuditResponse;
import page_pulse_backend.exception.AuditException;
import page_pulse_backend.util.SEOScoreCalculator;
import page_pulse_backend.util.UrlValidator;

@Service
public class AuditService {

    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public AuditResponse auditWebsite(String url) {

        if (!UrlValidator.isValid(url)) {
            throw new AuditException("Invalid URL. Use http:// or https://");
        }

        try {

            long start = System.currentTimeMillis();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(15))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            long end = System.currentTimeMillis();

            long responseTime = end - start;

            String contentType =
                    response.headers()
                            .firstValue("Content-Type")
                            .orElse("");

            if (!contentType.contains("text/html")) {
                throw new AuditException("URL does not return HTML content.");
            }

            Document document = Jsoup.parse(response.body());

            String title = document.title();

            String metaDescription =
                    document.select("meta[name=description]")
                            .attr("content");

            int h1Count =
                    document.select("h1").size();

            Elements images =
                    document.select("img");

            int imagesMissingAlt =
                    document.select("img:not([alt]), img[alt='']").size();

            String text =
                    document.body().text();

            int wordCount =
                    text.trim().isEmpty()
                            ? 0
                            : text.trim().split("\\s+").length;

            int seoScore =
                    SEOScoreCalculator.calculateScore(
                            title,
                            metaDescription,
                            h1Count,
                            imagesMissingAlt,
                            wordCount);

            return new AuditResponse(

                    url,

                    response.statusCode(),

                    responseTime,

                    title,

                    metaDescription,

                    h1Count,

                    imagesMissingAlt,

                    wordCount,

                    seoScore,

                    SEOScoreCalculator.generateRecommendations(

                            title,

                            metaDescription,

                            h1Count,

                            imagesMissingAlt,

                            wordCount));
        }

        catch (AuditException e) {

            throw e;

        }

        catch (Exception e) {

            throw new AuditException(

                    "Unable to audit website: " + e.getMessage(),

                    e);

        }

    }
}