import React from "react";
import { Typography } from "@mui/material";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";

const CreateCurriculum = () => {
  return (
    <div>
      <Typography
        variant="h4"
        color="inherit"
        sx={{ p: 1, mb: 1 }}
        align="center"
      >
        Create Curriculum
      </Typography>

      <TextField
        required
        id="filled-basic"
        label="Curriculum Name"
        variant="filled"
        sx={{ p: 1, mb: 1 }}
        fullWidth
      />
      <TextField
        required
        id="filled-basic"
        label="Registration Deadline"
        variant="filled"
        sx={{ p: 1, mb: 1 }}
        fullWidth
      />
      <Button variant="contained" color="success" sx={{ p: 1, mb: 1, ml: 1 }}>
        Save
      </Button>
    </div>
  );
};

export default CreateCurriculum;
