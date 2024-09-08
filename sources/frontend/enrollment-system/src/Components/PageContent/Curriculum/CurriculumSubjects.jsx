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

const CurriculumSubjects = () => {
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
        Curriculum's Subjects
      </Typography>

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
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
};

export default CurriculumSubjects;
