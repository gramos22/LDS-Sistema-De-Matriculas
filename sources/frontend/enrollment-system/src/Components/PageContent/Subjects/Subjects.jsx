import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

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
    4,
    "Monday 8:00 - 10:00",
    "Mandatory",
    "Ongoing",
    3500
  ),
  createData(
    "2",
    "Physics",
    4,
    "Tuesday 8:00 - 10:00",
    "Mandatory",
    "Ongoing",
    3500
  ),
  createData(
    "3",
    "Chemistry",
    4,
    "Wednesday 8:00 - 10:00",
    "Mandatory",
    "Ongoing",
    3500
  ),
  createData(
    "4",
    "Biology",
    4,
    "Thursday 8:00 - 10:00",
    "Mandatory",
    "Ongoing",
    3500
  ),
  createData(
    "5",
    "History",
    4,
    "Friday 8:00 - 10:00",
    "Mandatory",
    "Ongoing",
    3500
  ),
];

const SubjectsList = () => {
  const [courseType, setCourseType] = React.useState("");
  const [deadline, setDeadline] = React.useState("");

  const handleCourseTypeChange = (event) => {
    setCourseType(event.target.value);
  };

  const handleDeadlineChange = (event) => {
    setDeadline(event.target.value);
  };

  return (
    <Box sx={{ m: 3 }}>
      {/* Título */}
      <Typography variant="h3" color="inherit" sx={{ p: 1, mb: 1 }}>
        Available Subjects
      </Typography>
    </Box>
  );
};

export default SubjectsList;
