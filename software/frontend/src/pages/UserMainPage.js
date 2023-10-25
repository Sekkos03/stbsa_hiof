import React from 'react'
import Header from "../components/header/Header";
import picture1 from "../pictures/picture1.jpg";
import MainPageCountryDestination from "../components/destinations/PopularCountryDestinations";
import MainPageCityDestination from "../components/destinations/populareCitydestination";
import PopularTour from "../components/PopularTour";

function UserMainPage(){
    return(
        <>
            <Header />
            <div className = "image-Container">
                <img src = {picture1} id = "big-Picture" className=''/>
            </div>
            <MainPageCountryDestination/>
            <MainPageCityDestination/>
            <PopularTour />
        </>
    )
}

export default UserMainPage