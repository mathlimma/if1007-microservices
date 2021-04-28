import { useState, useEffect } from "react";
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
import axios from "./services/axios";

const App = () => {
  const [isLogged, setIsLogged] = useState();
  const [myKits, setMyKits] = useState([]);

  useEffect(() => {
    if (isLogged) {
      axios.get('/ks-core/api/v1/kits')
        .then((res) => setMyKits(res.data.content))
        .catch(err => console.log(err));
    }
  }, [isLogged]);

  const handleLogin = (token) => {
    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    setIsLogged(true);
  };

  return (
    <div className="App">
      <KsLoginModal isOpen={!isLogged} loginCallback={(token) => handleLogin(token)} />
      <Router>
        <KsNavbar />
        <Switch>
          <Route path="/search">
            <SearchPage />
          </Route>
          <Route path="/share">
            <SharePage kits={myKits} />
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
