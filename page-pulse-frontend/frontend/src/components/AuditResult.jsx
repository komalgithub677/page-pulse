import "./AuditResult.css";

function AuditResult({ result }) {
  return (
    <div className="result-container">

      <h2>Website Audit Report</h2>

      <div className="cards">

        <div className="card">
          <h3>HTTP Status</h3>
          <p>{result.status}</p>
        </div>

        <div className="card">
          <h3>Response Time</h3>
          <p>{result.responseTime} ms</p>
        </div>

        <div className="card">
          <h3>SEO Score</h3>
          <p className="seo-score">{result.seoScore}/100</p>
        </div>

      </div>

      <table>

        <tbody>

          <tr>
            <td>Website URL</td>
            <td>{result.url}</td>
          </tr>

          <tr>
            <td>Title</td>
            <td>{result.title || "N/A"}</td>
          </tr>

          <tr>
            <td>Meta Description</td>
            <td>{result.metaDescription || "N/A"}</td>
          </tr>

          <tr>
            <td>H1 Count</td>
            <td>{result.h1Count}</td>
          </tr>

          <tr>
            <td>Images Missing ALT</td>
            <td>{result.imagesMissingAlt}</td>
          </tr>

          <tr>
            <td>Word Count</td>
            <td>{result.wordCount}</td>
          </tr>

        </tbody>

      </table>

      <div className="recommendations">

        <h3>SEO Recommendations</h3>

        <ul>

          {result.recommendations.map((item, index) => (

            <li key={index}>
              ✅ {item}
            </li>

          ))}

        </ul>

      </div>

    </div>
  );
}

export default AuditResult;