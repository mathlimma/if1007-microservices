import './App.css';
import KsNavbar from './components/KsNavbar';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import SearchPage from "./pages/SearchPage";
import SharePage from "./pages/SharePage";

function App() {
  return (
    <div className="App">
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
