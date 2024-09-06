import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function StudentList() {
  const [students, setStudents] = useState([]);
  const [error, setError] = useState(null);

  // Pega a URL da API da variável de ambiente
  const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

  // Chamada à API para listar os estudantes
  useEffect(() => {
    fetch(`${API_BASE_URL}/students`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Erro ao buscar os estudantes");
        }
        return response.json();
      })
      .then((data) => {
        setStudents(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, [API_BASE_URL]);

  if (error) {
    return <div>Erro: {error}</div>;
  }

  return (
    <div>
      <h2>Lista de Estudantes</h2>
      {students.length > 0 ? (
        <ul>
          {students.map((student) => (
            <li key={student.id}>
              <Link to={`/students/${student.id}`}>
                {student.name} - {student.email}
              </Link>
            </li>
          ))}
        </ul>
      ) : (
        <p>Nenhum estudante encontrado.</p>
      )}
    </div>
  );
}

export default StudentList;
