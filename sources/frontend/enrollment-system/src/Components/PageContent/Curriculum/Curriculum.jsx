import React, { useState } from "react";
import Modal from "@mui/material/Modal";
import CreateCourse from "./CreateCurriculum";
import EditCourse from "./EditCurriculum";
import CurriculumSubjects from "./CurriculumSubjects";
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

// Função para criar os dados do currículo
function createData(curriculumId, semester, curriculumName, deadline, status) {
  return { curriculumId, semester, curriculumName, deadline, status };
}

// Dados de exemplo dos currículos (remover quando usar o back-end)
const rows = [
  createData(
    1,
    "1st semester",
    "Engineering Software01",
    "01/10/2024",
    "Ongoing Curriculum"
  ),
  createData(
    2,
    "2nd semester",
    "Engineering Software02",
    "01/10/2024",
    "Ongoing Curriculum"
  ),
  createData(
    3,
    "3rd semester",
    "Engineering Software03",
    "01/10/2024",
    "Ongoing Curriculum"
  ),
  createData(
    4,
    "4th semester",
    "Engineering Software04",
    "01/10/2024",
    "Ongoing Curriculum"
  ),
];

const modalStyle = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "80%", // Ajustado para acomodar o tamanho da tabela
  maxHeight: "80%", // Ajustado para permitir rolagem se necessário
  bgcolor: "background.paper",
  border: "2px solid #004d94",
  borderRadius: "16px",
  boxShadow: 24,
  p: 4,
  overflowY: "auto", // Adicionado para permitir rolagem vertical
};

const Curriculum = () => {
  const [openCreate, setOpenCreate] = useState(false);
  const [openEdit, setOpenEdit] = useState(null); // Controla o modal de edição de cada currículo
  const [openSubjects, setOpenSubjects] = useState(null); // Controla o modal de disciplinas

  const handleOpenCreate = () => setOpenCreate(true);
  const handleCloseCreate = () => setOpenCreate(false);

  const handleOpenEdit = (curriculumId) => setOpenEdit(curriculumId);
  const handleCloseEdit = () => setOpenEdit(null);

  const handleOpenSubjects = (curriculumId) => setOpenSubjects(curriculumId);
  const handleCloseSubjects = () => setOpenSubjects(null);

  return (
    <Box sx={{ m: 3 }}>
      <Typography variant="h3" color="inherit" sx={{ p: 1, mb: 1 }}>
        Available Curriculums
      </Typography>

      {/* Botão para criar um novo currículo */}
      <Box sx={{ mb: 3 }}>
        <Button variant="contained" size="large" onClick={handleOpenCreate}>
          Create Curriculum
        </Button>
        <Modal
          open={openCreate}
          onClose={handleCloseCreate}
          aria-labelledby="create-curriculum-modal-title"
          aria-describedby="create-curriculum-modal-description"
        >
          <Box sx={modalStyle}>
            <CreateCourse />
          </Box>
        </Modal>
      </Box>

      {/* Tabela de currículos */}
      <TableContainer component={Paper} sx={{ m: 1 }}>
        <Table sx={{ minWidth: 650 }} aria-label="curriculum table">
          <TableHead>
            <TableRow>
              <TableCell align="center">Curriculum ID</TableCell>
              <TableCell align="center">Semester</TableCell>
              <TableCell align="center">Curriculum Name</TableCell>
              <TableCell align="center">Registration Deadline</TableCell>
              <TableCell align="center">Status</TableCell>
              <TableCell align="center">Actions</TableCell>
              
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow
                key={row.curriculumId}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row" align="center">
                  {row.curriculumId}
                </TableCell>
                <TableCell align="center">{row.semester}</TableCell>
                <TableCell align="center">{row.curriculumName}</TableCell>
                <TableCell align="center">{row.deadline}</TableCell>
                <TableCell align="center">{row.status}</TableCell>
                <TableCell align="center">
                  <Stack direction="row" spacing={2} justifyContent="center">
                    {/* Botão de Editar */}
                    <Button
                      variant="contained"
                      color="success"
                      onClick={() => handleOpenEdit(row.curriculumId)}
                    >
                      Edit
                    </Button>
                    <Modal
                      open={openEdit === row.curriculumId}
                      onClose={handleCloseEdit}
                      aria-labelledby="edit-curriculum-modal-title"
                      aria-describedby="edit-curriculum-modal-description"
                    >
                      <Box sx={modalStyle}>
                        <EditCourse />
                      </Box>
                    </Modal>

                    {/* Botão de Disciplinas */}
                    <Button
                      color="secondary"
                      onClick={() => handleOpenSubjects(row.curriculumId)}
                    >
                      Subjects
                    </Button>
                    <Modal
                      open={openSubjects === row.curriculumId}
                      onClose={handleCloseSubjects}
                      aria-labelledby="subjects-modal-title"
                      aria-describedby="subjects-modal-description"
                    >
                      <Box sx={modalStyle}>
                        <CurriculumSubjects />
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

export default Curriculum;
