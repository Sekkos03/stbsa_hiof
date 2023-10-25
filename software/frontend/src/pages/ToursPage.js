import React, {useEffect, useState} from 'react'
import Header from "../components/header/Header";
import {useParams} from "react-router-dom";
import picture from "./picture1.jpg"
import BokingForm from "../components/BokingForm";

function ToursPage(){

    const [tour, setTour] = useState({});
    const { tourID } = useParams();

    useEffect(() => {
        fetch('http://localhost:8080/OneTour/' + tourID)
            .then(response => response.json())
            .then(data => setTour(data))
            .catch(error => console.error(error));
    });

    return(
        <>
            <Header />
            <div className="container mt-4">
                <div className="row">
                    <div className="col-md-6">
                        <img
                            src={picture}
                            alt={tour.name}
                            className="img-fluid rounded"
                        />
                    </div>
                    <div className="col-md-6">
                        <h1 className="mb-3">{tour.name}</h1>
                        <p className="lead">{tour.description}</p>
                        <p className="text-muted">Price: ${tour.price}</p>
                    </div>
                </div>
            </div>
            <BokingForm maxPeople={tour.maxPeople}/>
        </>
    )
}

export default ToursPage