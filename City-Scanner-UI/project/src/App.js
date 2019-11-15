import React, { Component } from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";

import Home from "./Home";
// import Footer from "./Footer";
import Header from "./Header";
import temp from "./temp";
import Dashboard from "./Dashboard";
import Restaurants from "./Restaurants";
import Map from "./Map";
import "./App.css";
import Flip from "./Flip";

class App extends Component {
  render() {
    return (
      <>
        <Router>
          <Header />
          <Route exact path="/" component={Home} />
          <Route exact path="/Map" component={Map} />

          <Route exact path="/temp" component={temp} />
          <Route exact path="/Restaurants" component={Restaurants} />

          <Route exact path="/home" component={Home} />
          <Route exact path="/Dashboard" component={Dashboard} />
          <Route exact path="/Flip" component={Flip} />

          {/* <Footer /> */}
        </Router>
      </>
    );
  }
}

export default App;