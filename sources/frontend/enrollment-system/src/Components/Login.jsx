import { Button, Card, Container, TextField } from "@mui/material";
import "./Components.css";
import Typography from "@mui/material/Typography";
import loginImg from "../img/login-img.png";

const Login = () => {
  return (
    <Card sx={{ width: "30%" }} className="App-header">
      <img
        src={loginImg}
        alt="loginImg"
        style={{ width: "60%", marginTop: "32px", marginLeft: "16px" }}
      />
      <Typography
        variant="h3"
        component="h2"
        className="Sigin-title"
        sx={{ py: 2, mt: 2, mb: 2, marginLeft: "32px" }}
      >
        Sign in
      </Typography>
      <Container>
        <TextField
          sx={{ my: 2 }}
          id="filled-basic"
          label="E-mail"
          variant="filled"
          fullWidth
        />
        <TextField
          sx={{ my: 2 }}
          id="filled-basic"
          label="Password"
          variant="filled"
          fullWidth
        />
        <div>
          <Button variant="contained" className="Login-btn" sx={{ my: 2 }}>
            Sign in
          </Button>
        </div>
      </Container>
    </Card>
  );
};

export default Login;
