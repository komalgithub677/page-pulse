<div align="center">

# ⚡ Page Pulse

### Audit any webpage. Get the essentials in seconds.

A modern full-stack website auditing tool that analyzes any public webpage and provides useful insights about **HTTP performance, SEO metadata, accessibility, and page structure**.

<br>

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![React](https://img.shields.io/badge/React-Vite-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Jsoup](https://img.shields.io/badge/Jsoup-HTML_Parser-59666C?style=for-the-badge)
![JUnit](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

<br>

[🌐 Live Demo](YOUR_LIVE_URL) •
[🎥 Video Walkthrough](YOUR_LOOM_URL) •
[🐛 Report Issue](https://github.com/YOUR_GITHUB_USERNAME/page-pulse/issues)

</div>

---

## 📖 About Page Pulse

**Page Pulse** is a lightweight website auditing application that allows users to enter any publicly accessible URL and instantly receive a structured report about the webpage.

The application analyzes important information such as:

- 🌐 HTTP response status
- ⚡ Response time
- 📝 Page title
- 🔎 Meta description
- 🏷️ H1 heading count
- 🖼️ Images missing alternative text
- 📖 Approximate word count

The goal is to provide a simple and clean way to quickly inspect the basic **performance, SEO, accessibility, and structural characteristics** of a webpage.

---

## ✨ Features

### 🔍 Website Analysis

Enter a public HTTP or HTTPS URL and Page Pulse fetches and analyzes the webpage automatically.

### ⚡ Performance Information

Displays the HTTP response status and approximate server-side fetch response time.

### 🔎 SEO Insights

Extracts important SEO-related information including:

- Page title
- Meta description
- H1 heading count

### ♿ Accessibility Check

Identifies images that are missing meaningful `alt` attributes based on the parser's configured rules.

### 📊 Content Statistics

Calculates an approximate word count from the parsed page content.

### 🛡️ Reliable Error Handling

The application gracefully handles scenarios such as:

- Invalid URLs
- Unsupported URL schemes
- Request timeouts
- Unreachable websites
- Non-HTML responses
- Unexpected upstream errors

The application returns meaningful error messages instead of exposing raw server exceptions.

---

## 🖥️ Application Preview

> Add a screenshot of your deployed application here after completing the frontend.

```text
┌──────────────────────────────────────────────────────────────┐
│                                                              │
│                       ⚡ PAGE PULSE                           │
│                                                              │
│              Audit any webpage in seconds.                   │
│                                                              │
│   ┌─────────────────────────────────────┐  ┌─────────────┐   │
│   │ https://example.com                 │  │   Analyze   │   │
│   └─────────────────────────────────────┘  └─────────────┘   │
│                                                              │
│                     AUDIT OVERVIEW                           │
│                                                              │
│      HTTP Status                    Response Time             │
│        200 OK                          245 ms                 │
│                                                              │
│      H1 Tags                       Missing Alt Text           │
│         1                               2                     │
│                                                              │
│      Approximate Word Count                                  │
│              428                                             │
│                                                              │
└──────────────────────────────────────────────────────────────┘
```

Once you have a screenshot, place it inside:

```text
docs/page-pulse-preview.png
```

Then uncomment:

<!--
![Page Pulse Preview](./docs/page-pulse-preview.png)
-->

---

## 🏗️ Architecture

```text
                         ┌───────────────────┐
                         │       USER        │
                         └─────────┬─────────┘
                                   │
                              Enters URL
                                   │
                                   ▼
                         ┌───────────────────┐
                         │   React Frontend  │
                         │      + Vite       │
                         └─────────┬─────────┘
                                   │
                            POST /api/audit
                                   │
                                   ▼
                         ┌───────────────────┐
                         │ Spring Boot REST  │
                         │       API         │
                         └─────────┬─────────┘
                                   │
                     Validate + Fetch Website
                                   │
                                   ▼
                         ┌───────────────────┐
                         │   Jsoup Parser    │
                         └─────────┬─────────┘
                                   │
              ┌────────────────────┼────────────────────┐
              │                    │                    │
              ▼                    ▼                    ▼
        ┌───────────┐       ┌───────────┐       ┌────────────┐
        │    SEO    │       │Accessibility│      │ Page Stats │
        │ Metadata  │       │   Checks    │      │ & Content  │
        └───────────┘       └─────────────┘      └────────────┘
              │                    │                    │
              └────────────────────┼────────────────────┘
                                   │
                                   ▼
                         ┌───────────────────┐
                         │    JSON Report    │
                         └─────────┬─────────┘
                                   │
                                   ▼
                         ┌───────────────────┐
                         │  Results Dashboard│
                         └───────────────────┘
```

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| **Java 17** | Backend programming language |
| **Spring Boot** | REST API and backend application |
| **Jsoup** | Fetching and parsing HTML documents |
| **React** | Frontend user interface |
| **Vite** | Frontend development and build tooling |
| **JUnit 5** | Backend unit testing |
| **Mockito** | Mocking dependencies where required |
| **Maven** | Backend dependency management |
| **Git & GitHub** | Version control and source hosting |

---

## 📁 Project Structure

```text
page-pulse/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/com/pagepulse/
│   │   │       ├── controller/
│   │   │       │   └── AuditController.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   ├── AuditRequest.java
│   │   │       │   └── AuditResponse.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── AuditService.java
│   │   │       │
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       └── PagePulseApplication.java
│   │   │
│   │   └── test/
│   │       └── java/com/pagepulse/
│   │           └── AuditServiceTest.java
│   │
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── AuditForm.jsx
│   │   │   ├── AuditReport.jsx
│   │   │   ├── ErrorMessage.jsx
│   │   │   └── LoadingSpinner.jsx
│   │   │
│   │   ├── services/
│   │   │   └── auditApi.js
│   │   │
│   │   ├── App.jsx
│   │   └── main.jsx
│   │
│   └── package.json
│
├── docs/
│   └── page-pulse-preview.png
│
├── .gitignore
└── README.md
```

---

# 🚀 Getting Started

## Prerequisites

Make sure the following tools are installed:

```text
Java 17+
Maven
Node.js
npm
Git
```

Check your installations:

```bash
java -version
mvn -version
node -v
npm -v
git --version
```

---

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/page-pulse.git

cd page-pulse
```

---

## 2️⃣ Run the Backend

Navigate to the backend:

```bash
cd backend
```

Run using Maven:

```bash
mvn spring-boot:run
```

Or, if using the Maven wrapper:

### Windows

```bash
mvnw.cmd spring-boot:run
```

### macOS / Linux

```bash
./mvnw spring-boot:run
```

The backend will start at:

```text
http://localhost:8080
```

---

## 3️⃣ Run the Frontend

Open another terminal:

```bash
cd frontend

npm install

npm run dev
```

Vite will display the local development URL, typically:

```text
http://localhost:5173
```

Open it in your browser.

---

# 🔌 API Documentation

## Audit a Webpage

```http
POST /api/audit
```

### Request

```json
{
  "url": "https://example.com"
}
```

### Successful Response

```json
{
  "url": "https://example.com",
  "httpStatus": 200,
  "responseTimeMs": 245,
  "title": "Example Domain",
  "metaDescription": "",
  "h1Count": 1,
  "imagesMissingAlt": 0,
  "wordCount": 28
}
```

### Example Error

```json
{
  "success": false,
  "error": "INVALID_URL",
  "message": "Please enter a valid HTTP or HTTPS URL."
}
```

---

## ⚠️ Error Handling

Page Pulse converts expected failures into clear API responses.

| Scenario | HTTP Status | Behaviour |
|---|---:|---|
| Invalid URL | `400` | Returns a validation error |
| Unsupported protocol | `400` | Only HTTP/HTTPS accepted |
| Unreachable website | `502` | Returns upstream connection error |
| Request timeout | `504` | Returns timeout message |
| Non-HTML response | `415` | Rejects unsupported content |
| Unexpected error | `500` | Returns safe generic error |

Raw Java stack traces are never intentionally exposed through the public API.

---

# 🧪 Testing

Tests focus primarily on the parsing and auditing logic.

Run all backend tests:

```bash
cd backend

mvn test
```

### Test Coverage

The test suite includes scenarios such as:

```text
✓ Valid HTML parsing — Happy Path

✓ Missing title or meta description

✓ Images without alt attributes

✓ Empty or unusual page content

✓ Invalid/non-HTML input handling
```

Controlled HTML fixtures are preferred over live websites to keep parsing tests **fast, deterministic, and independent of external services**.

---

# 🧠 Design Decisions

## 1. Parsing Logic Is Separated From Network Logic

Fetching a webpage and parsing its HTML are separate responsibilities.

This makes the parsing logic easier to unit test using controlled HTML documents without requiring real network requests.

It also makes the application easier to maintain because each component has a focused responsibility.

---

## 2. URLs Are Validated Before Fetching

The backend accepts only supported HTTP and HTTPS URLs.

Because the server fetches a URL supplied by the user, validation is important for both reliability and security.

Unsafe or unsupported targets are rejected according to the validation rules implemented by the application.

This design also helps reduce **Server-Side Request Forgery (SSRF)** risks.

---

## 3. Structured Error Responses

Instead of returning raw exceptions, the API converts known failure scenarios into predictable JSON responses.

For example:

```json
{
  "success": false,
  "error": "REQUEST_TIMEOUT",
  "message": "The website took too long to respond."
}
```

This keeps the API contract predictable and allows the frontend to display meaningful messages to users.

---

# 🔐 Security Considerations

Since Page Pulse fetches user-provided URLs from the backend, URL handling requires special care.

The application is designed to:

- Accept only `http://` and `https://`
- Validate URL syntax before fetching
- Apply request timeouts
- Reject unsupported content types
- Avoid exposing internal exception details

For a production-grade version, additional SSRF protections such as DNS resolution validation, private-network blocking, redirect re-validation, rate limiting, and request-size limits should also be implemented.

---

# 📌 Assumptions

The following assumptions were made while implementing the assignment:

- Only publicly accessible HTTP/HTTPS webpages are supported.
- Authentication-protected pages are outside the current scope.
- Response time represents the backend fetch operation rather than full browser rendering time.
- Word count is an approximation based on parsed page text.
- JavaScript-rendered content may not be fully available because the application analyzes the fetched HTML response without executing JavaScript.
- Image accessibility is evaluated using the alt-text rules implemented by the parser.

---

# ⚡ Performance

The application records the approximate time required for the backend to fetch the target webpage.

```text
Request Started
      │
      ▼
Fetch Target URL
      │
      ▼
Receive Response
      │
      ▼
Calculate Elapsed Time
      │
      ▼
responseTimeMs
```

> This metric is not equivalent to Core Web Vitals or full browser page-load performance.

---

# 🌍 Deployment

The application can be deployed using:

```text
                    GitHub Repository
                           │
                 ┌─────────┴─────────┐
                 │                   │
                 ▼                   ▼
          React Frontend       Spring Boot API
                 │                   │
                 ▼                   ▼
              Vercel              Render
                 │                   │
                 └─────────┬─────────┘
                           │
                           ▼
                    Live Page Pulse
```

### Production URLs

| Service | URL |
|---|---|
| 🌐 Frontend | `YOUR_VERCEL_URL` |
| ⚙️ Backend | `YOUR_RENDER_URL` |
| 💻 Repository | `YOUR_GITHUB_URL` |
| 🎥 Loom Demo | `YOUR_LOOM_URL` |

---

# 🚧 Limitations

Page Pulse is intentionally a lightweight webpage auditor rather than a complete browser-based auditing platform.

Current limitations include:

- JavaScript-generated content may not appear in the initial HTML.
- Response time is not equivalent to browser rendering performance.
- Word count is approximate.
- Accessibility auditing currently focuses on the requested image alt-text metric.
- It does not currently provide Lighthouse/Core Web Vitals analysis.

---

# 🔮 Future Improvements

With additional development time, I would explore:

- 📈 Lighthouse / Core Web Vitals integration
- 🔗 Broken-link detection
- 🧭 Redirect-chain analysis
- 🏷️ Canonical tag validation
- 🤖 `robots.txt` analysis
- 🗺️ Sitemap detection
- ♿ Extended accessibility auditing
- 📊 SEO scoring
- 💾 Audit history
- 📄 PDF report export
- 🚦 Rate limiting
- ⚡ Response caching
- 🔐 Stronger SSRF protection
- 🧪 End-to-end and integration testing

---

# 🤖 AI Usage

AI tools were used as a development assistant during this project for architecture brainstorming, implementation guidance, edge-case identification, debugging support, and documentation review.

All AI-generated suggestions were reviewed before being used. I adapted the recommendations to the actual project requirements and made my own implementation decisions regarding the application structure, API design, validation, error handling, tests, user interface, and documentation.

The final implementation was tested and reviewed to ensure that I could understand and explain the code and the decisions made throughout the project.

---

# 🎥 Demo Walkthrough

A short walkthrough demonstrates:

1. Auditing a valid webpage.
2. Handling an invalid or failing request.
3. The backend parsing architecture.
4. Automated tests.
5. One area of the implementation I would improve with additional time.

🎬 **Watch the Loom Demo:** [Click here](YOUR_LOOM_URL)

---

# 👩‍💻 Author

**Komal Narawade**

Computer Science & Engineering  
Java Full Stack Developer

[![GitHub](https://img.shields.io/badge/GitHub-Profile-181717?style=flat&logo=github)](https://github.com/YOUR_GITHUB_USERNAME)

---

<div align="center">

### ⚡ Page Pulse

**Simple audits. Useful insights. Better webpages.**

<br>

Built for **Digital Heroes Training Task**

[Digital Heroes](https://digitalheroesco.com)

<br>

⭐ If you found this project useful, consider giving the repository a star.

</div>
