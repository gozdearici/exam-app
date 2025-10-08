export default function ExamList({ exams }) {
  if (!exams || exams.length === 0) return <p>No exams found.</p>;

  return (
    <div>
      {exams.map((exam) => (
        <div key={exam.id} style={{ border: "1px solid #ddd", padding: "12px", marginBottom: "8px" }}>
          <h3>{exam.title}</h3>
          <p>{exam.description}</p>
          <ol>
            {exam.questions?.map((q, i) => (
              <li key={i}>{q}</li>
            ))}
          </ol>
        </div>
      ))}
    </div>
  );
}
