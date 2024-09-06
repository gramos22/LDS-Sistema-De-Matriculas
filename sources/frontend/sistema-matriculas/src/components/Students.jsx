import React, { useEffect, useState } from "react";
import { getAllStudents, deleteStudent } from "../Api";

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const data = await getAllStudents();
        setStudents(data);
      } catch (error) {
        console.error("Erro ao buscar estudantes", error);
      }
    };

    fetchStudents();
  }, []);

  const handleDelete = async (id) => {
    try {
      await deleteStudent(id);
      setStudents(students.filter((student) => student.id !== id)); // Remove o estudante da lista
    } catch (error) {
      console.error("Erro ao deletar estudante", error);
    }
  };

  return (
    <div>
      <h1>Lista de Estudantes</h1>
      <ul>
        {students.map((student) => (
          <li key={student.id}>
            {student.name} - {student.email}
            <button onClick={() => handleDelete(student.id)}>Deletar</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudentList;
