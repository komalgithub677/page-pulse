# Page Pulse

Page Pulse is a full-stack web application that audits a public webpage and returns a concise report covering HTTP response information, basic SEO metadata, accessibility signals, and page content statistics.

The project was built as part of the Digital Heroes Software Development (SDE) practical task.

## Live Demo

Frontend:
<ADD_YOUR_FRONTEND_URL>

Backend API:
<ADD_YOUR_BACKEND_URL>

GitHub Repository:
<ADD_YOUR_GITHUB_URL>

Loom Walkthrough:
<ADD_YOUR_LOOM_URL>

---

## Features

Page Pulse accepts a public HTTP/HTTPS URL and reports:

- HTTP status code
- Response time
- Page title
- Meta description
- H1 tag count
- Images missing alt text
- Approximate word count

The application also handles common failure cases such as:

- Invalid URLs
- Unsupported URL schemes
- Connection failures
- Request timeouts
- Non-HTML responses
- Unexpected upstream errors

---

## Tech Stack

### Frontend

- React
- Vite
- CSS / Tailwind CSS

### Backend

- Java 17
- Spring Boot
- Jsoup
- Maven

### Testing

- JUnit 5
- Mockito, where required

---

## Project Structure

```text
page-pulse/
├── backend/
│   ├── src/main/
│   ├── src/test/
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   └── package.json
│
└── README.md
