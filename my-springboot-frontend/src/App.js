// App.js

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import StadesList from './components/StadesList';
import Equipe from './components/Equipe';
import Player from './components/player';
import Match from './components/match';
import Entraineur from './components/entraineur';
import Navbar from './components/NavBar';

const App = () => {
  return (
    <Router>
      <Navbar/>
      <div>
        
        <Routes>
          <Route path="/stades" element={<StadesList />} />
          <Route path="/equipe" element={<Equipe/>} />
          <Route path="/match" element={<Match/>} />
          <Route path="/player" element={<Player/>} />
          <Route path="/entraineur" element={<Entraineur/>} />
          {/* Add more routes for other components */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;
