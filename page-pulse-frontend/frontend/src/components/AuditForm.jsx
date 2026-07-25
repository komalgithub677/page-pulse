import { useState } from "react";
import api from "../services/api";
import Loader from "./Loader";
import AuditResult from "./AuditResult";

function AuditForm() {

    const [url, setUrl] = useState("");

    const [loading, setLoading] = useState(false);

    const [result, setResult] = useState(null);

    const [error, setError] = useState("");

    const handleSubmit = async (e) => {

        e.preventDefault();

        setError("");

        setResult(null);

        if (!url.trim()) {

            setError("Please enter a website URL.");

            return;

        }

        try {

            setLoading(true);

            const response = await api.post("/audit", {

                url: url.trim()

            });

            setResult(response.data);

        }

        catch (err) {

            if (err.response?.data?.message) {

                setError(err.response.data.message);

            } else {

                setError("Unable to connect to the server.");

            }

        }

        finally {

            setLoading(false);

        }

    };

    return (

        <>

            <form
                className="audit-form"
                onSubmit={handleSubmit}
            >

                <input

                    type="text"

                    placeholder="https://example.com"

                    value={url}

                    onChange={(e) =>
                        setUrl(e.target.value)
                    }

                />

                <button type="submit">

                    🔍 Analyze Website

                </button>

            </form>

            {loading && <Loader />}

            {error &&

                <div className="error-card">

                    <h3>❌ Error</h3>

                    <p>{error}</p>

                </div>

            }

            {result &&

                <AuditResult result={result} />

            }

        </>

    );

}

export default AuditForm;