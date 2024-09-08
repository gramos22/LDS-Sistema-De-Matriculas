import "./App.css";
import AppFooter from "./Components/AppFooter/index";

import Dashboard from "./Components/Comm/Dashboard";
import AppHeader from "./Components/AppHeader/index";

function App() {
  return (
    <div className="App">
      <AppHeader />
      <Dashboard />

      <AppFooter />
    </div>
  );
}

export default App;
