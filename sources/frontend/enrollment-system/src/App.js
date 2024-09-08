import "./App.css";
import Login from "./Components/Login";
import { Outlet } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Outlet />
        <Login />
      </header>
    </div>
  );
}

export default App;
