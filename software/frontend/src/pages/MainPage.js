import React from 'react';
import Header from '../components/header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import CarouselDestinations from "../components/carousel/CarouselDestinations";


function MainPage() {

    return (
        <>
            <Header />
            <CarouselDestinations />
        </>
    );
}

export default MainPage;

