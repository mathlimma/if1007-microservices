import { useState } from "react";
import './App.scss';
import KsNavbar from './components/KsNavbar';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import SearchPage from "./pages/SearchPage";
import SharePage from "./pages/SharePage";
import KsLoginModal from "./components/KsLoginModal";

const App = () => {
  const [token, setToken] = useState();

  return (
    <div className="App">
      <KsLoginModal isOpen={!token} loginCallback={(tkn) => setToken(tkn)} />
      <Router>
        <KsNavbar />
        <Switch>
          <Route path="/search">
            <SearchPage />
          </Route>
          <Route path="/share">
            <SharePage />
          </Route>
          <Route path="/">
            <Redirect to="/share" />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
