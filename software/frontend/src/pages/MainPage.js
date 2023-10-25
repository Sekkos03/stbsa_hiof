import React from 'react';
import Header from '../components/header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import picture1 from "../pictures/picture1.jpg";
import './MainPage.css'
import MainPageCountryDestination from "../components/destinations/PopularCountryDestinations";
import MainPageCityDestination from "../components/destinations/populareCitydestination";
import PopularTour from "../components/PopularTour";


function MainPage() {

    return (
        <>
            <Header />
            <div className = "image-Container">
            <img src = {picture1} id = "big-Picture" className=''/>
            </div>
            <MainPageCountryDestination/>
            <MainPageCityDestination/>
            <PopularTour />
        </>
    );
}

export default MainPage;

