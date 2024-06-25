import React from 'react';
import './App.css';


import 'bootstrap/dist/css/bootstrap.min.css';
import SelectProvinciaComponent from './components/option-provincia';
import SelectCantonComponent from './components/option-canton';
import SelectParroquiaComponent from './components/option-parroquia';

function App() {

  const [selectedProvincia, setSelectedProvincia] = React.useState('');
  const [selectedCanton, setSelectedCanton] = React.useState('');
  const [selectedParroquia, setSelectedParroquia] = React.useState('');

  const handleProvinciaChange = (value: string) => {
    setSelectedProvincia(value);
    setSelectedCanton('');
    setSelectedParroquia('');
  };

  const handleCantonChange = (value: string) => {
    setSelectedCanton(value);
    setSelectedParroquia('');
  };

  const handleParroquiaChange = (value: string) => {
    setSelectedParroquia(value);
  };

  return (
    <div className="App">
      <header className="App-header">
        <div className="App">
          <div className="alert alert-primary" role="alert">
            <span>DPA por Parroquia - Cantón - Parroquia</span>
          </div>
        </div>
        <div className="container">
          <SelectProvinciaComponent onProvinciaChange={handleProvinciaChange} />
          <SelectCantonComponent provinciaId={selectedProvincia} onCantonChange={handleCantonChange} />
          <SelectParroquiaComponent provinciaId={selectedProvincia} cantonId={selectedCanton} onParroquiaChange={handleParroquiaChange} />
        </div>
        <div className='container-results'>
          <div className='results-code'>
            <span className="badge text-bg-danger">Codigo de Provincia</span>
            <div className="alert alert-danger" role="alert">
              2345
            </div>
          </div>
          <div className='results-code'>
            <span className="badge text-bg-danger">Codigo de Cantón</span>
            <div className="alert alert-danger" role="alert">
              2345
            </div>
          </div>
          <div className='results-code'>
            <span className="badge text-bg-danger">Codigo de Parroquia</span>
            <div className="alert alert-danger" role="alert">
              23546
            </div>
          </div>
        </div>
      </header>
    </div>
  );
}

export default App;
