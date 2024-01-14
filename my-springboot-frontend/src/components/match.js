import React, { useState } from 'react';
import SportsSoccerIcon from '@mui/icons-material/SportsSoccer';
import EventIcon from '@mui/icons-material/Event';
import LocationOnIcon from '@mui/icons-material/LocationOn';

const Match = () => {
  const [backgroundColor, setBackgroundColor] = useState('linear-gradient(45deg, #3498db, #1abc9c)');

  const matchContainerStyle = {
    border: '1px solid #e0e0e0',
    borderRadius: '8px',
    boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
    padding: '20px',
    margin: '20px',
    background: backgroundColor,
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    color: '#fff',
    transition: 'background 0.3s ease-in-out',
    cursor: 'pointer',
  };

  const matchTitleStyle = {
    textAlign: 'center',
    marginBottom: '10px',
    fontSize: '24px',
  };

  const matchInfoStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  };

  const iconStyle = {
    fontSize: '36px',
    color: '#fff',
    marginBottom: '5px',
  };

  const teamTextStyle = {
    fontSize: '18px',
    fontWeight: 'bold',
    marginBottom: '5px',
    textShadow: '2px 2px 4px rgba(0, 0, 0, 0.5)',
  };

  const matchDetailStyle = {
    fontSize: '16px',
    marginBottom: '5px',
  };

  const handleMouseEnter = () => {
    setBackgroundColor('linear-gradient(45deg, #e74c3c, #c0392b)');
  };

  const handleMouseLeave = () => {
    setBackgroundColor('linear-gradient(45deg, #3498db, #1abc9c)');
  };

  return (
    <div
      style={matchContainerStyle}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
    >
      <h2 style={matchTitleStyle}>Match Details</h2>
      <div style={matchInfoStyle}>
        <SportsSoccerIcon style={iconStyle} />
        <p style={teamTextStyle}>Team A 🆚 Team B</p>
        <EventIcon style={iconStyle} />
        <p style={matchDetailStyle}>Date: January 13, 2024</p>
        <LocationOnIcon style={iconStyle} />
        <p style={matchDetailStyle}>Location: Stadium Name</p>
        {/* Additional match details */}
      </div>
      {/* Add other components or content related to the match */}
    </div>
  );
};

export default Match;
