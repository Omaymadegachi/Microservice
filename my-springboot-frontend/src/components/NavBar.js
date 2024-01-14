// Navbar.js

import React from 'react';
import { AppBar, Toolbar, Link as MuiLink } from '@mui/material';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <AppBar position="static">
      <Toolbar>
        <MuiLink component={Link} to="/stades" color="inherit" underline="none" style={{ marginRight: '20px' }}>
          Stade
        </MuiLink>
        <MuiLink component={Link} to="/match" color="inherit" underline="none" style={{ marginRight: '20px' }}>
          Match
        </MuiLink>
        <MuiLink component={Link} to="/player" color="inherit" underline="none" style={{ marginRight: '20px' }}>
          Player
        </MuiLink>
        <MuiLink component={Link} to="/entraineur" color="inherit" underline="none" style={{ marginRight: '20px' }}>
          Entraineur
        </MuiLink>
        <MuiLink component={Link} to="/equipe" color="inherit" underline="none">
          Equipe
        </MuiLink>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
