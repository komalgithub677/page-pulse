package page_pulse_backend.util;

import java.util.ArrayList;
import java.util.List;

public class SEOScoreCalculator {

    private SEOScoreCalculator() {
    }

    public static int calculateScore(
            String title,
            String metaDescription,
            int h1Count,
            int imagesMissingAlt,
            int wordCount) {

        int score = 100;

        if (title == null || title.isBlank()) {
            score -= 20;
        }

        if (metaDescription == null || metaDescription.isBlank()) {
            score -= 20;
        }

        if (h1Count == 0) {
            score -= 15;
        }

        if (imagesMissingAlt > 0) {
            score -= Math.min(imagesMissingAlt * 5, 20);
        }

        if (wordCount < 300) {
            score -= 15;
        }

        return Math.max(score, 0);
    }

    public static List<String> generateRecommendations(
            String title,
            String metaDescription,
            int h1Count,
            int imagesMissingAlt,
            int wordCount) {

        List<String> recommendations = new ArrayList<>();

        if (title == null || title.isBlank()) {
            recommendations.add("Page title is missing.");
        }

        if (metaDescription == null || metaDescription.isBlank()) {
            recommendations.add("Meta description is missing.");
        }

        if (h1Count == 0) {
            recommendations.add("No H1 heading found.");
        }

        if (imagesMissingAlt > 0) {
            recommendations.add(imagesMissingAlt
                    + " image(s) are missing alt attributes.");
        }

        if (wordCount < 300) {
            recommendations.add("Increase page content to at least 300 words.");
        }

        if (recommendations.isEmpty()) {
            recommendations.add("Great! No SEO issues found.");
        }

        return recommendations;
    }
}