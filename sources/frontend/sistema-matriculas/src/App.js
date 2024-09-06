import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import StudentCreate from "./components/StudentCreate";
import StudentList from "./components/StudentList";
import StudentDetails from "./components/StudentDetails";
import StudentEdit from "./components/StudentEdit";

function App() {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Listar Estudantes</Link>
            </li>
            <li>
              <Link to="/create">Criar Estudante</Link>
            </li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<StudentList />} />
          <Route path="/create" element={<StudentCreate />} />
          <Route path="/students/:id" element={<StudentDetails />} />
          <Route path="/edit/:id" element={<StudentEdit />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
