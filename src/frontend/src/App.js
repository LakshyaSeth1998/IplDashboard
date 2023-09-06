import './App.scss';
import { TeamPage } from './pages/TeamPage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import { MatchPage } from './pages/MatchPage';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/teams/:teamName/matches/:year" element={<MatchPage />}></Route>
          <Route path="/teams/:teamName" element={<TeamPage />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
