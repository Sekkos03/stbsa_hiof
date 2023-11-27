import React, {useEffect, useState} from 'react';
import BookedTourList from "../components/BookedTourList";
import HeaderGuide from "../components/header/HeaderGuide";
import {useParams} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

function GuideMainPage(){

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


    return(
        <>
            <HeaderGuide User={Guide}/>
            <div className="container" style={{ marginBottom: '5px' , marginTop: '5px'}}>
            <BookedTourList User={Guide}/>
            </div>
        </>
    )
}

export default GuideMainPage