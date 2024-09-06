import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

function StudentEdit() {
  const { id } = useParams();
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    fetch(`http://localhost:8080/students/${id}`)
      .then((response) => response.json())
      .then((data) => {
        setName(data.name);
        setEmail(data.email);
      })
      .catch((error) => console.error("Erro ao buscar estudante:", error));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch(`http://localhost:8080/students/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, email }),
    })
      .then(() => {
        navigate(`/students/${id}`);
      })
      .catch((error) => console.error("Erro ao atualizar estudante:", error));
  };

  return (
    <div>
      <h2>Editar Estudante</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Nome:
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </label>
        <label>
          Email:
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </label>
        <button type="submit">Salvar</button>
      </form>
    </div>
  );
}

export default StudentEdit;
