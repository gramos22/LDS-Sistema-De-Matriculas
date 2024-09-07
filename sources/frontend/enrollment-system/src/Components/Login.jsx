import { Button, Card, Container, TextField } from "@mui/material";

const Login = () => {
  return (
    <Card sx={{ width: "30%" }}>
      <Container>
        <TextField
          id="filled-basic"
          label="User e-mail"
          variant="filled"
          fullWidth
        />
        <TextField
          id="filled-basic"
          label="User Password"
          variant="filled"
          fullWidth
        />
        <div>
          <Button variant="contained">Contained</Button>
        </div>
      </Container>
    </Card>
  );
};

export default Login;
