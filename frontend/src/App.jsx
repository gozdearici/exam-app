import { useEffect, useState } from "react";
import CreateExam from "./components/CreateExam";
import ExamList from "./components/ExamList";

export default function App() {
  const [exams, setExams] = useState([]);

  const fetchExams = async () => {
    try {
      const res = await fetch("http://localhost:8080/api/exams");
      const data = await res.json();
      setExams(data);
    } catch (err) {
      console.error(err);
      alert("Failed to load exams");
    }
  };

  useEffect(() => {
    fetchExams();
  }, []);

  return (
    <div style={{ maxWidth: 800, margin: "2rem auto", padding: "1rem" }}>
      <h1>Exam App</h1>
      <CreateExam onCreated={fetchExams} />
      <hr />
      <ExamList exams={exams} />
    </div>
  );
}
