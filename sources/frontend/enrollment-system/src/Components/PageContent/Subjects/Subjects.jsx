import React, { useState } from "react";
import CurriculumSubjects from "../Curriculum/CurriculumSubjects";
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
  Modal,
} from "@mui/material";

// Função para criar os dados das disciplinas
function createData(
  subjectID,
  SubjectName,
  credits,
  classSchedule,
  type,
  status,
  price
) {
  return {
    subjectID,
    SubjectName,
    credits,
    classSchedule,
    type,
    status,
    price,
  };
}

const rows = [
  createData(
    "1",
    "Math",
    "4",
    "Mandatory",
    "Monday 8:00 - 10:00",
    "Ongoing",
    "3500"
  ),
  createData(
    "2",
    "Physics",
    "4",
    "Mandatory",
    "Tuesday 8:00 - 10:00",
    "Ongoing",
    "3500"
  ),
  createData(
    "3",
    "Chemistry",
    "4",
    "Mandatory",
    "Wednesday 8:00 - 10:00",
    "Ongoing",
    "3500"
  ),
  createData(
    "4",
    "Biology",
    "4",
    "Mandatory",
    "Thursday 8:00 - 10:00",
    "Ongoing",
    "3500"
  ),
  createData(
    "5",
    "History",
    "4",
    "Mandatory",
    "Friday 8:00 - 10:00",
    "Ongoing",
    "3500"
  ),
];

// Definindo o estilo do modal
const modalStyle = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "80%",
  bgcolor: "background.paper",
  border: "2px solid #004d94",
  borderRadius: "16px",
  boxShadow: 24,
  p: 4,
  overflowY: "auto",
};

const SubjectsList = () => {
  const [openEdit, setOpenEdit] = useState(null); // Controla o modal de edição
  const [openSubjects, setOpenSubjects] = useState(null); // Controla o modal de disciplinas
  const [openCreate, setOpenCreate] = useState(false); // Controla o modal de criação de currículo

  // Funções para abrir e fechar o modal de edição
  const handleOpenEdit = (subjectID) => setOpenEdit(subjectID);
  const handleCloseEdit = () => setOpenEdit(null);

  // Funções para abrir e fechar o modal de disciplinas
  const handleOpenSubjects = (subjectID) => setOpenSubjects(subjectID);
  const handleCloseSubjects = () => setOpenSubjects(null);

  // Funções para abrir e fechar o modal de criação de currículo
  const handleOpenCreate = () => setOpenCreate(true);
  const handleCloseCreate = () => setOpenCreate(false);

  return (
    <Box sx={{ m: 3 }}>
      {/* Título */}
      <Typography variant="h3" color="inherit" sx={{ p: 1, mb: 1 }}>
        Available Subjects
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
            {/* Conteúdo do modal de criação de currículo */}
            <Typography id="create-curriculum-modal-title" variant="h6">
              Create New Curriculum
            </Typography>
            <div>Form to create a new curriculum here</div>
          </Box>
        </Modal>
      </Box>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell align="center">Subject Name</TableCell>
              <TableCell align="center">Credits</TableCell>
              <TableCell align="center">Type</TableCell>
              <TableCell align="center">Class Schedule</TableCell>
              <TableCell align="center">Status</TableCell>
              <TableCell align="center">Price</TableCell>
              <TableCell align="center">Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow
                key={row.subjectID}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.subjectID}
                </TableCell>
                <TableCell align="center">{row.SubjectName}</TableCell>
                <TableCell align="center">{row.credits}</TableCell>
                <TableCell align="center">{row.classSchedule}</TableCell>
                <TableCell align="center">{row.type}</TableCell>
                <TableCell align="center">{row.status}</TableCell>
                <TableCell align="center">{row.price}</TableCell>
                <TableCell align="center">
                  <Stack direction="row" spacing={2} justifyContent="center">
                    {/* Botão de Editar */}
                    <Button
                      variant="contained"
                      color="success"
                      onClick={() => handleOpenEdit(row.subjectID)}
                    >
                      Edit
                    </Button>
                    <Modal
                      open={openEdit === row.subjectID}
                      onClose={handleCloseEdit}
                      aria-labelledby="edit-subject-modal-title"
                      aria-describedby="edit-subject-modal-description"
                    >
                      <Box sx={modalStyle}>
                        {/* Substitua por seu componente EditSubject */}
                        <div>Edit Subject Content Here</div>
                      </Box>
                    </Modal>

                    <Modal
                      open={openSubjects === row.subjectID}
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

export default SubjectsList;
