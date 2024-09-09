import React from "react";
import {
  Typography,
  TextField,
  Button,
  Box,
  InputLabel,
  MenuItem,
  FormControl,
  Select,
} from "@mui/material";

const EditCurriculum = () => {
  const [courseType, setCourseType] = React.useState("");
  const [deadline, setDeadline] = React.useState("");

  const handleCourseTypeChange = (event) => {
    setCourseType(event.target.value);
  };

  const handleDeadlineChange = (event) => {
    setDeadline(event.target.value);
  };

  return (
    <Box sx={{ p: 3 }}>
      {/* Título */}
      <Typography variant="h4" align="center" sx={{ mb: 3 }}>
        Edit Curriculum
      </Typography>

      {/* Campo de texto para nome do currículo */}
      <TextField
        id="curriculum-name"
        label="Curriculum Name"
        variant="filled"
        sx={{ mb: 2 }}
        fullWidth
        defaultValue="Default Curriculum Name"
      />

      {/* Campo de texto para prazo do currículo */}
      <TextField
        id="curriculum-deadline"
        label="Curriculum Deadline"
        variant="filled"
        sx={{ mb: 2 }}
        fullWidth
        defaultValue="Default Deadline"
      />

      {/* Botão de salvar */}
      <Button variant="contained" color="success" fullWidth sx={{ mb: 2 }}>
        Save
      </Button>
    </Box>
  );
};

export default EditCurriculum;
