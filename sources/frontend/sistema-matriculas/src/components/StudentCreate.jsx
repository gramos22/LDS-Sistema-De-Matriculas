import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function StudentCreate() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/students", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, email }),
    })
      .then((response) => response.json())
      .then(() => {
        navigate("/");
      })
      .catch((error) => console.error("Erro ao criar estudante:", error));
  };

  return (
    <div>
      <h2>Criar Estudante</h2>
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
        <button type="submit">Criar</button>
      </form>
    </div>
  );
}

export default StudentCreate;
