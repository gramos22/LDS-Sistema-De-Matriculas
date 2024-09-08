import React from "react"; // Don't forget to import React
import loginImg from "../../img/logo.png"; // Import the image
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
const AppFooter = () => {
  return (
    <footer className="AppFooter">
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar>
            <Typography
              variant="h6"
              component="div"
              sx={{ flexGrow: 1 }}
            ></Typography>
            <p color="inherit">© 2021 Enrollment System</p>
          </Toolbar>
        </AppBar>
      </Box>
    </footer>
  );
};
export default AppFooter;
