import React, { Component } from "react";
import CitiesSlider from "./CitiesSlider";
import Flip from "./Flip";

export default class HomeComponent extends Component {
  render() {
    return (
      <React.Fragment>
        <CitiesSlider />
        <Flip />
      </React.Fragment>
    );
  }
}