import React from "react";
import { Typography } from "@mui/material";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";

const CreateCourse = () => {
  return (
    <div>
      <Typography
        variant="h4"
        color="inherit"
        sx={{ p: 1, mb: 1 }}
        align="center"
      >
        Create Course
      </Typography>
      <TextField
        id="filled-basic"
        label="Course Name"
        variant="filled"
        sx={{ p: 1, mb: 1 }}
        fullWidth
      />
      <TextField
        id="filled-basic"
        label="Course Type"
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

export default CreateCourse;
