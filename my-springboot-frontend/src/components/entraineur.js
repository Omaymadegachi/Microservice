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

const Entraineur = () => {
  const [entraineurs, setEntraineurs] = useState([]);
  const [selectedEntraineur, setSelectedEntraineur] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [isAddModalOpen, setIsAddModalOpen] = useState(false);
  const [newEntraineurData, setNewEntraineurData] = useState({
    firstName: '',
    lastName: '',
    nation: '',
    picture: '',
    equipe_id: 0,
  });

  const fetchEntraineurs = async () => {
    try {
      const response = await axios.get('http://localhost:8086/entraineurs/');
      setEntraineurs(response.data);
    } catch (error) {
      console.error('Error fetching entraineurs:', error);
    }
  };

  useEffect(() => {
    fetchEntraineurs();
  }, []);

  const handleOpenModal = (entraineur) => {
    setSelectedEntraineur(entraineur);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setSelectedEntraineur(null);
    setIsModalOpen(false);
  };

  const handleOpenAddModal = () => {
    setIsAddModalOpen(true);
  };

  const handleCloseAddModal = () => {
    setIsAddModalOpen(false);
  };

  const handleSaveEntraineur = async () => {
    try {
      // Send a POST request to your API endpoint with new entraineur data
      await axios.post('http://localhost:8086/entraineurs/', newEntraineurData);

      // After successful save, close the modal and refresh the entraineur list
      handleCloseAddModal();
      fetchEntraineurs();
    } catch (error) {
      console.error('Error saving entraineur:', error);
      // Handle error as needed
    }
  };

  const handleInputChange = (field, value) => {
    setNewEntraineurData((prevData) => ({
      ...prevData,
      [field]: value,
    }));
  };

  return (
    <div>
      <Typography variant="h5" gutterBottom>
        Entraineur List
      </Typography>

      <Button variant="contained" color="primary" onClick={handleOpenAddModal}>
        Add Entraineur
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
              <TableCell>Equipe ID</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {entraineurs.map((entraineur) => (
              <TableRow key={entraineur.id}>
                <TableCell>{entraineur.id}</TableCell>
                <TableCell>{entraineur.firstName}</TableCell>
                <TableCell>{entraineur.lastName}</TableCell>
                <TableCell>{entraineur.nation}</TableCell>
                <TableCell>{entraineur.picture}</TableCell>
                <TableCell>{entraineur.equipe_id}</TableCell>
                <TableCell>
                  <Button variant="outlined" onClick={() => handleOpenModal(entraineur)}>
                    View Details
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      {/* Entraineur Details Modal */}
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
          {selectedEntraineur && (
            <div>
              <Typography variant="h6" gutterBottom>
                Entraineur Details
              </Typography>
              <TextField label="ID" value={selectedEntraineur.id} fullWidth disabled />
              <TextField label="First Name" value={selectedEntraineur.firstName} fullWidth disabled />
              <TextField label="Last Name" value={selectedEntraineur.lastName} fullWidth disabled />
              <TextField label="Nation" value={selectedEntraineur.nation} fullWidth disabled />
              <TextField label="Picture" value={selectedEntraineur.picture} fullWidth disabled />
              <TextField label="Equipe ID" value={selectedEntraineur.equipe_id} fullWidth disabled />
            </div>
          )}
        </Box>
      </Modal>

      {/* Add Entraineur Modal */}
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
              Add Entraineur
            </Typography>
            <TextField
              label="First Name"
              fullWidth
              value={newEntraineurData.firstName}
              onChange={(e) => handleInputChange('firstName', e.target.value)}
            />
            <TextField
              label="Last Name"
              fullWidth
              value={newEntraineurData.lastName}
              onChange={(e) => handleInputChange('lastName', e.target.value)}
            />
            <TextField
              label="Nation"
              fullWidth
              value={newEntraineurData.nation}
              onChange={(e) => handleInputChange('nation', e.target.value)}
            />
            <TextField
              label="Picture"
              fullWidth
              value={newEntraineurData.picture}
              onChange={(e) => handleInputChange('picture', e.target.value)}
            />
            <TextField
              label="Equipe ID"
              fullWidth
              value={newEntraineurData.equipe_id}
              onChange={(e) => handleInputChange('equipe_id', e.target.value)}
            />
            <Button variant="contained" color="primary" onClick={handleSaveEntraineur}>
              Save
            </Button>
          </div>
        </Box>
      </Modal>
    </div>
  );
};

export default Entraineur;
