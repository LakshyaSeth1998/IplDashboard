import './App.scss';
import { TeamPage } from './pages/TeamPage';
import { HashRouter as Router, Route, Routes } from 'react-router-dom'
import { MatchPage } from './pages/MatchPage';
import { HomePage } from './pages/HomePage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/teams/:teamName/matches/:year" element={<MatchPage />}></Route>
          <Route path="/teams/:teamName" element={<TeamPage />}></Route>
          <Route path="/" element={<HomePage />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
