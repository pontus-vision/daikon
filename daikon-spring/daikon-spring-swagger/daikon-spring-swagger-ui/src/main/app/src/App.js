import React, { Component } from 'react';
import './App.css';
import logo from './images/talend_logo.png';
import SwaggerUI from "swagger-ui-react"
import "swagger-ui-react/swagger-ui.css"

const getBaseURL = () => {
  const urlMatches = /(.*)\/.*/.exec(window.location.href);
  return urlMatches[1] + "/v2/api-docs";
};

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <ul className="header-bar-items">
              <li className="header-bar-item">
                <img alt="Talend" src={logo}/>
              </li>
          </ul>
        </header>
        <SwaggerUI url={getBaseURL()} />
      </div>
    );
  }
}

export default App
