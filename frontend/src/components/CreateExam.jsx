import { useState } from "react";

export default function CreateExam({ onCreated }) {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [questionsText, setQuestionsText] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const questions = questionsText
      .split("\n")
      .map((s) => s.trim())
      .filter(Boolean);
    const payload = { title, description, questions };

    try {
      const res = await fetch("http://localhost:8080/api/exams", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });
      if (!res.ok) {
        const err = await res.json().catch(() => ({ message: "Unknown error" }));
        alert(err.message || "Error creating exam");
        return;
      }
      setTitle("");
      setDescription("");
      setQuestionsText("");
      onCreated();
    } catch (err) {
      console.error(err);
      alert("Network error");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "1rem" }}>
      <div>
        <input
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          style={{ width: "100%", padding: "8px" }}
        />
      </div>
      <div style={{ marginTop: 8 }}>
        <input
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          style={{ width: "100%", padding: "8px" }}
        />
      </div>
      <div style={{ marginTop: 8 }}>
        <textarea
          placeholder="One question per line"
          value={questionsText}
          onChange={(e) => setQuestionsText(e.target.value)}
          rows={6}
          style={{ width: "100%", padding: "8px" }}
        />
      </div>
      <button type="submit" style={{ marginTop: 8 }}>
        Create Exam
      </button>
    </form>
  );
}
