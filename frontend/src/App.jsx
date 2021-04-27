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
  const [token, setToken] = useState();
  const [myKits, setMyKits] = useState([]);

  useEffect(() => {
    if (token) {
      axios.get('/ks-core/api/v1/kits', {
        headers: {
          'Authorization': 'Bearer ' + token
        }
      }).then((res) => setMyKits(res.data.content))
        .catch(err => console.log(err));
    }
  }, [token]);

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
