import React, { useState } from "react";
import { useParams } from "react-router-dom";

function StudentDetail() {
  const { id } = useParams(); // Obtém o ID do estudante da URL
  const [student, setStudent] = useState(null);
  const [error, setError] = useState(null);

  // Pega a URL da API da variável de ambiente
  const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

  // Chamada à API para obter os detalhes do estudante
  useState(() => {
    fetch(`${API_BASE_URL}/students/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Erro ao buscar o estudante");
        }
        return response.json();
      })
      .then((data) => {
        setStudent(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, [id, API_BASE_URL]);

  if (error) {
    return <div>Erro: {error}</div>;
  }

  return (
    <div>
      <h2>Detalhes do Estudante</h2>
      {student ? (
        <div>
          <p>
            <strong>ID:</strong> {student.id}
          </p>
          <p>
            <strong>Nome:</strong> {student.name}
          </p>
          <p>
            <strong>Email:</strong> {student.email}
          </p>
          {/* Adicione mais campos conforme necessário */}
        </div>
      ) : (
        <p>Carregando...</p>
      )}
    </div>
  );
}

export default StudentDetail;
