// StadesList.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Typography, List, ListItem, Paper, Drawer, ListItemIcon, IconButton, Button, Divider, Dialog, DialogTitle, DialogContent, DialogActions, TextField } from '@mui/material';
import { Edit as EditIcon, Add as AddIcon } from '@mui/icons-material';


const StadesList = () => {
  const [stades, setStades] = useState([]);
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);
  const [isAddStadeModalOpen, setIsAddStadeModalOpen] = useState(false);
  const [newStade, setNewStade] = useState({ name: '', capacity: '' });

  useEffect(() => {
    const fetchStades = async () => {
      try {
        const response = await axios.get('http://localhost:8087/stades/');
        setStades(response.data);
      } catch (error) {
        console.warn(error)
        // console.error('Error fetching stades:', error);
      }
    };

    fetchStades();
  }, []);

  const handleDrawerOpen = () => {
    setIsDrawerOpen(true);
  };

  const handleDrawerClose = () => {
    setIsDrawerOpen(false);
  };

  const handleEditStade = (stadeId) => {
    // Implement your logic for editing a stade
    console.log(`Editing stade with ID: ${stadeId}`);
  };

  const handleAddStade = () => {
    setIsAddStadeModalOpen(true);
  };

  const handleCloseAddStadeModal = () => {
    setIsAddStadeModalOpen(false);
    // Reset the input values when the modal is closed
    setNewStade({ name: '', capacity: '' });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStade((prevStade) => ({
      ...prevStade,
      [name]: value,
    }));
  };

  const handleSaveStade = async() => {
    const response = await axios.post('http://localhost:8087/stades/', newStade);
    
    console.log('Saving a new stade:', newStade);
    // Close the modal after saving
    handleCloseAddStadeModal();
    const updatedResponse = await axios.get('http://localhost:8087/stades/');
    setStades(updatedResponse.data);  };

  return (
    <div>
      <Paper elevation={3} style={{ maxWidth: 600, margin: '0 auto', padding: 16 }}>
        <Typography variant="h5" gutterBottom>
          Stades List
        </Typography>
        <List>
          {stades.map(stade => (
            <ListItem key={stade.id} button>
              <ListItemIcon>
                <IconButton edge="start" aria-label="edit" onClick={() => handleEditStade(stade.id)}>
                  <EditIcon />
                </IconButton>
              </ListItemIcon>
              {stade.name}
            </ListItem>
          ))}
        </List>
        <Divider />
        <Button variant="contained" color="primary" onClick={handleAddStade} startIcon={<AddIcon />}>
          Ajouter Stade
        </Button>

        {/* Add Stade Modal */}
        <Dialog open={isAddStadeModalOpen} onClose={handleCloseAddStadeModal}>
          <DialogTitle>Ajouter un nouveau stade</DialogTitle>
          <DialogContent>
            <TextField
              autoFocus
              margin="dense"
              label="Nom du stade"
              type="text"
              fullWidth
              name="name"
              value={newStade.name}
              onChange={handleInputChange}
            />
            <TextField
              margin="dense"
              label="Capacité"
              type="text"
              fullWidth
              name="capacity"
              value={newStade.capacity}
              onChange={handleInputChange}
            />
          </DialogContent>
          <DialogActions>
            <Button onClick={handleCloseAddStadeModal} color="primary">
              Annuler
            </Button>
            <Button onClick={handleSaveStade} color="primary">
              Enregistrer
            </Button>
          </DialogActions>
        </Dialog>
      </Paper>
    </div>
  );
};

export default StadesList;
