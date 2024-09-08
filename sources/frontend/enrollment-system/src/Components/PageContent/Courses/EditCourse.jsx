import React from "react";
import {
  Typography,
  TextField,
  Button,
  InputLabel,
  MenuItem,
  FormControl,
  Select,
  Box,
} from "@mui/material";

const EditCourse = () => {
  const [courseType, setCourseType] = React.useState("");

  const handleChange = (event) => {
    setCourseType(event.target.value);
  };

  return (
    <div>
      {/* Título */}
      <Typography
        variant="h4"
        color="inherit"
        sx={{ p: 1, mb: 1 }}
        align="center"
      >
        Edit Course
      </Typography>

      {/* Campo de texto para nome do curso */}
      <TextField
        id="filled-basic"
        label="Course Name"
        variant="filled"
        sx={{ p: 1, mb: 1 }}
        fullWidth
        defaultValue="Vir do back"
      />

      {/* Select para tipo de curso */}
      <Box sx={{ minWidth: 120, p: 1, mb: 1 }} fullWidth>
        <FormControl fullWidth>
          <InputLabel id="course-type-select-label">Course Type</InputLabel>
          <Select
            labelId="course-type-select-label"
            id="course-type-select"
            value={courseType}
            label="Course Type"
            onChange={handleChange}
            fullWidth
          >
            <MenuItem value="Bachelors">Bachelors</MenuItem>
            <MenuItem value="Masters">Masters</MenuItem>
            <MenuItem value="Doctorate">Doctorate</MenuItem>
            <MenuItem value="Virtual">Virtual</MenuItem>
          </Select>
        </FormControl>
      </Box>

      {/* Botão de salvar */}
      <Button variant="contained" color="success" sx={{ p: 1, mb: 1, ml: 1 }}>
        Save
      </Button>
    </div>
  );
};

export default EditCourse;
