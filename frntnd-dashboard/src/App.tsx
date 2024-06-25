import React from 'react';
import './App.css';


import 'bootstrap/dist/css/bootstrap.min.css';
import SelectComponent from './components/option';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div className="App">
          <div className="alert alert-primary" role="alert">
            <span>DPA por Parroquia - Cantón - Parroquia</span>
          </div>
        </div>
        <div className="container">
          <SelectComponent />
          <select className="form-select" aria-label="Default select example">
            <option selected>Canton</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
          </select>
          <select className="form-select" aria-label="Default select example">
            <option selected>Parroquia</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
          </select>
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
