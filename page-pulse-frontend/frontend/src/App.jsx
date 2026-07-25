import "./App.css";
import AuditForm from "./components/AuditForm";

function App() {
  return (
    <div className="app">
      <header className="header">
        <h1>🚀 Page Pulse</h1>
        <p>Website Audit & SEO Analyzer</p>
      </header>

      <main>
        <AuditForm />
      </main>

      <footer className="footer">
        <p>© 2026 Page Pulse | Built with React + Spring Boot</p>
      </footer>
    </div>
  );
}

export default App;