import React from 'react';
import Header from '../components/header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import picture1 from "../pictures/picture1.jpg";
import './MainPage.css'
import MainPageCountryDestination from "../components/MainPageCountryDestinations";


function MainPage() {

    return (
        <>
            <Header />
            <div className = "image-Container">
            <img src = {picture1} id = "big-Picture" className=''/>
            </div>
            <MainPageCountryDestination/>

        </>
    );
}

export default MainPage;

