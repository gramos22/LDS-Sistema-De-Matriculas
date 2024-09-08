import "./App.css";
import AppFooter from "./Components/AppFooter/index";
import Login from "./Components/Login";
import PageContent from "./Components/PageContent/Secretary/SecretaryPage";
import AppHeader from "./Components/AppHeader/index";
import { Space } from "antd";

function App() {
  return (
    <div className="App">
      <AppHeader />
      <PageContent></PageContent>

      <AppFooter />
    </div>
  );
}

export default App;
