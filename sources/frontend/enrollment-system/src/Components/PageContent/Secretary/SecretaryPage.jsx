import React from "react";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Courses from "./Courses";

export default function PageContent() {
  const [value, setValue] = React.useState(2);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <Tabs
        sx={{ m: 3 }}
        value={value}
        onChange={handleChange}
        aria-label="disabled tabs example"
      >
        <Tab label="Students" />
        <Tab label="Subjects" />
        <Tab label="Professors" />
        <Tab label="Curriculuns" />
        <Tab label="Courses" />
      </Tabs>

      <Courses />
    </div>
  );
}
