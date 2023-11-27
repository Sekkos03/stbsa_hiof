import React, {useEffect, useState} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './MainPage.css'
import HeaderGuide from "../components/header/HeaderGuide";
import {useParams} from "react-router-dom";



function MakeNewTour() {

    const { GuideID } = useParams();
    const [Guide, setGuide] = useState({});

    useEffect(() => {
        if (GuideID) {
            fetch('http://localhost:8080/getGuideByID/' + GuideID)
                .then(response => response.json())
                .then(data => setGuide(data))
                .catch(error => console.error(error));
        }
        else {
            setGuide(null)
        }
    }, [GuideID]);


    return (
        <>
            <HeaderGuide User={Guide}/>
        </>
    );
}

export default MakeNewTour;

