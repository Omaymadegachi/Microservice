import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Card, CardContent, Typography, CardActions, Button, Grid, Modal, Box, TextField } from '@mui/material';

const Equipe = () => {
  const [equipes, setEquipes] = useState([]);
  const [isAddModalOpen, setIsAddModalOpen] = useState(false);
  const [newEquipeData, setNewEquipeData] = useState({
    name: '',
    location: '',
  });

  const fetchEquipes = async () => {
    try {
      const response = await axios.get('http://localhost:8086/equipes/');
      setEquipes(response.data);
    } catch (error) {
      console.error('Error fetching equipes:', error);
    }
  };

  useEffect(() => {
    fetchEquipes();
  }, []);

  const handleOpenAddModal = () => {
    setIsAddModalOpen(true);
  };

  const handleCloseAddModal = () => {
    setIsAddModalOpen(false);
  };

  const handleSaveEquipe = async () => {
    try {
      // Send a POST request to your API endpoint with new equipe data
      await axios.post('http://localhost:8086/equipes/', newEquipeData);

      // After successful save, close the modal and refresh the equipe list
      handleCloseAddModal();
      fetchEquipes();
    } catch (error) {
      console.error('Error saving equipe:', error);
      // Handle error as needed
    }
  };

  const handleInputChange = (field, value) => {
    setNewEquipeData((prevData) => ({
      ...prevData,
      [field]: value,
    }));
  };

  return (
    <div>
      <Grid container spacing={2}>
        {equipes.map((equipe) => (
          <Grid item key={equipe.id} xs={12} sm={6} md={4} lg={3}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">
                  {equipe.name}
                </Typography>
                <Typography color="text.secondary">{equipe.location}</Typography>
              </CardContent>
              <CardActions>
                <Button size="small" color="primary">
                  View Details
                </Button>
              </CardActions>
            </Card>
          </Grid>
        ))}
      </Grid>

      {/* Add Equipe Modal */}
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
              Add Equipe
            </Typography>
            <TextField
              label="Name"
              fullWidth
              value={newEquipeData.name}
              onChange={(e) => handleInputChange('name', e.target.value)}
            />
            <TextField
              label="Location"
              fullWidth
              value={newEquipeData.location}
              onChange={(e) => handleInputChange('location', e.target.value)}
            />
            <Button variant="contained" color="primary" onClick={handleSaveEquipe}>
              Save
            </Button>
          </div>
        </Box>
      </Modal>

      {/* Button to Open Add Equipe Modal */}
      <Button variant="contained" color="primary" onClick={handleOpenAddModal}>
        Add Equipe
      </Button>
    </div>
  );
};

export default Equipe;
