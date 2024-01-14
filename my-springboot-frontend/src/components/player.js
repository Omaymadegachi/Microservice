// Player.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Typography,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Button,
  Modal,
  Box,
  TextField,
} from '@mui/material';

const Player = () => {
  const [players, setPlayers] = useState([]);
  const [selectedPlayer, setSelectedPlayer] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [isAddModalOpen, setIsAddModalOpen] = useState(false);
  const [newPlayerData, setNewPlayerData] = useState({
    firstName: '',
    lastName: '',
    nation: '',
    picture: '',
    joueurRole: '',
    equipe_id: '',
    numero: '',
  });

  const fetchPlayers = async () => {
    try {
      const response = await axios.get('http://localhost:8086/joueurs/');
      console.log(response.data[0].equipe_id)
      setPlayers(response.data);
    } catch (error) {
      console.error('Error fetching players:', error);
    }
  };

  useEffect(() => {
    fetchPlayers();
  }, []);

  const handleOpenModal = (player) => {
    setSelectedPlayer(player);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setSelectedPlayer(null);
    setIsModalOpen(false);
  };

  const handleOpenAddModal = () => {
    setIsAddModalOpen(true);
  };

  const handleCloseAddModal = () => {
    setIsAddModalOpen(false);
  };

  const handleSavePlayer = async () => {
    try {
      // Send a POST request to your API endpoint with new player data
      await axios.post('http://localhost:8086/joueurs/', newPlayerData);

      // After successful save, close the modal and refresh the player list
      handleCloseAddModal();
      fetchPlayers();
    } catch (error) {
      console.error('Error saving player:', error);
      // Handle error as needed
    }
  };

  const handleInputChange = (field, value) => {
    setNewPlayerData((prevData) => ({
      ...prevData,
      [field]: value,
    }));
  };

  return (
    <div>
      <Typography variant="h5" gutterBottom>
        Player List
      </Typography>

      <Button variant="contained" color="primary" onClick={handleOpenAddModal}>
        Add Player
      </Button>

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>First Name</TableCell>
              <TableCell>Last Name</TableCell>
              <TableCell>Nation</TableCell>
              <TableCell>Picture</TableCell>
              <TableCell>Role</TableCell>
              <TableCell>Equipe ID</TableCell>
              <TableCell>Numero</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {players.map((player) => (
              <TableRow key={player.id}>
                <TableCell>{player.id}</TableCell>
                <TableCell>{player.firstName}</TableCell>
                <TableCell>{player.lastName}</TableCell>
                <TableCell>{player.nation}</TableCell>
                <TableCell>{player.picture}</TableCell>
                <TableCell>{player.joueurRole}</TableCell>
                <TableCell>{player.equipe_id}</TableCell>
                <TableCell>{player.numero}</TableCell>
                <TableCell>
                  <Button variant="outlined" onClick={() => handleOpenModal(player)}>
                    View Details
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      {/* Player Details Modal */}
      <Modal open={isModalOpen} onClose={handleCloseModal}>
        <Box
          sx={{
            position: 'absolute',
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            width: 400,
            bgcolor: 'background.paper',
            boxShadow: 24,
            p: 4,
          }}
        >
          {selectedPlayer && (
            <div>
              <Typography variant="h6" gutterBottom>
                Player Details
              </Typography>
              <TextField label="ID" value={selectedPlayer.id} fullWidth disabled />
              <TextField label="First Name" value={selectedPlayer.firstName} fullWidth disabled />
              <TextField label="Last Name" value={selectedPlayer.lastName} fullWidth disabled />
              <TextField label="Nation" value={selectedPlayer.nation} fullWidth disabled />
              <TextField label="Picture" value={selectedPlayer.picture} fullWidth disabled />
              <TextField label="Role" value={selectedPlayer.joueurRole} fullWidth disabled />
              <TextField label="Equipe ID" value={selectedPlayer.equipe_id} fullWidth disabled />
              <TextField label="Numero" value={selectedPlayer.numero} fullWidth disabled />
            </div>
          )}
        </Box>
      </Modal>

      {/* Add Player Modal */}
      <Modal open={isAddModalOpen} onClose={handleCloseAddModal}>
        <Box
          sx={{
            position: 'absolute',
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            width: 400,
            bgcolor: 'background.paper',
            boxShadow: 24,
            p: 4,
          }}
        >
          <div>
            <Typography variant="h6" gutterBottom>
              Add Player
            </Typography>
            <TextField
              label="First Name"
              fullWidth
              value={newPlayerData.firstName}
              onChange={(e) => handleInputChange('firstName', e.target.value)}
            />
            <TextField
              label="Last Name"
              fullWidth
              value={newPlayerData.lastName}
              onChange={(e) => handleInputChange('lastName', e.target.value)}
            />
            <TextField
              label="Nation"
              fullWidth
              value={newPlayerData.nation}
              onChange={(e) => handleInputChange('nation', e.target.value)}
            />
            <TextField
              label="Picture"
              fullWidth
              value={newPlayerData.picture}
              onChange={(e) => handleInputChange('picture', e.target.value)}
            />
            <TextField
              label="Role"
              fullWidth
              value={newPlayerData.joueurRole}
              onChange={(e) => handleInputChange('joueurRole', e.target.value)}
            />
            <TextField
              label="Equipe ID"
              fullWidth
              value={newPlayerData.equipe_id}
              onChange={(e) => handleInputChange('equipe_id', e.target.value)}
            />
            <TextField
              label="Numero"
              fullWidth
              value={newPlayerData.numero}
              onChange={(e) => handleInputChange('numero', e.target.value)}
            />
            <Button variant="contained" color="primary" onClick={handleSavePlayer}>
              Save
            </Button>
          </div>
        </Box>
      </Modal>
    </div>
  );
};

export default Player;
