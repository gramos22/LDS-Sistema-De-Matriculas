import React, { useState } from "react";
import Modal from "@mui/material/Modal";
import CreateCourse from "./CreateCourse";
import EditCourse from "./EditCourse";
import {
  Box,
  Typography,
  Button,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Stack,
} from "@mui/material";

// Função para criar os dados do curso
function createData(courseId, courseName, courseType) {
  return { courseId, courseName, courseType };
}

// Dados de exemplo dos cursos ESTATITCOS TIRAR QUANDO COLOCAR O BACK
const rows = [
  createData(1, "Engineering Software", "BACHELORS"),
  createData(2, "Computer Science", "MASTER"),
  createData(3, "Information Systems", "DOCTORATE"),
  createData(4, "Computer Engineering", "VIRTUAL"),
];

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  border: "2px solid #004d94",
  borderRadius: "16px",
  boxShadow: 24,
  p: 4,
};

const Courses = () => {
  const [openCreate, setOpenCreate] = useState(false);
  const [openEdit, setOpenEdit] = useState(null); // Controla o modal de edição de cada curso

  const handleOpenCreate = () => setOpenCreate(true);
  const handleCloseCreate = () => setOpenCreate(false);

  const handleOpenEdit = (courseId) => setOpenEdit(courseId); // Abre o modal de edição para o curso específico
  const handleCloseEdit = () => setOpenEdit(null); // Fecha o modal de edição

  return (
    <Box sx={{ m: 3 }}>
      <Typography variant="h3" color="inherit" sx={{ p: 1, mb: 1 }}>
        Available Courses
      </Typography>

      {/* Botão para criar um novo curso */}
      <Box sx={{ "& button": { m: 1, mb: 3 } }}>
        <Button variant="contained" size="large" onClick={handleOpenCreate}>
          Create Course
        </Button>
        <Modal
          open={openCreate}
          onClose={handleCloseCreate}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <CreateCourse />
          </Box>
        </Modal>
      </Box>

      {/* Tabela de cursos */}
      <TableContainer component={Paper} sx={{ m: 1 }}>
        <Table sx={{ minWidth: 650 }} aria-label="course table">
          <TableHead>
            <TableRow>
              <TableCell align="center">Course ID</TableCell>
              <TableCell align="center">Course Name</TableCell>
              <TableCell align="center">Course Type</TableCell>
              <TableCell align="center">Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow
                key={row.courseId}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row" align="center">
                  {row.courseId}
                </TableCell>
                <TableCell align="center">{row.courseName}</TableCell>
                <TableCell align="center">{row.courseType}</TableCell>
                <TableCell align="center">
                  <Stack direction="row" spacing={2} justifyContent="center">
                    {/* Botão de Editar */}
                    <Button
                      variant="contained"
                      color="success"
                      onClick={() => handleOpenEdit(row.courseId)}
                    >
                      Edit
                    </Button>
                    <Modal
                      open={openEdit === row.courseId}
                      onClose={handleCloseEdit}
                      aria-labelledby="modal-modal-title"
                      aria-describedby="modal-modal-description"
                    >
                      <Box sx={style}>
                        <EditCourse />
                      </Box>
                    </Modal>

                    {/* Botão de Deletar */}
                    <Button variant="outlined" color="error">
                      Delete
                    </Button>
                  </Stack>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
};

export default Courses;
