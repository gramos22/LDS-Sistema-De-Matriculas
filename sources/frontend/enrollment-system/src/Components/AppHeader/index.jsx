import React from "react"; // Don't forget to import React
import loginImg from "../../img/logo.png"; // Import the image
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";

const AppHeader = () => {
  return (
    <header className="AppHeader">
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar>
            <img src={loginImg} alt="Login" width={100} />
            <Typography
              variant="h6"
              component="div"
              sx={{ flexGrow: 1 }}
            ></Typography>
            <Button color="inherit">School Enrollment System</Button>
          </Toolbar>
        </AppBar>
      </Box>
    </header>
  );
};

export default AppHeader;
