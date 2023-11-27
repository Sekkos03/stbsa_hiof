import React, {useEffect, useState} from 'react';
import Button from "react-bootstrap/button";
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";

function Tour({ bookedTour }) {

    const [Tour, setTour] = useState({});

    useEffect(() => {
        if (bookedTour) {
            axios.get(`http://localhost:8080/OneTour/${bookedTour.tourID}`)
                .then(response => {
                    setTour(response.data);
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }, [bookedTour.tourID]);

    const removeBookedTour = (indexToRemove) => {
        axios.delete(`http://localhost:8080/deleteOneItemFromBookedTour/${bookedTour.bookedTourID}`)
            .then(result => {
                window.location.reload();
            })
            .catch(error => {
                console.error(error)
                alert("There was an error removing the tour. Please try again.");
            }, [bookedTour.bookedTourID])
    }


    return (
        <div className="col-md-4 mb-4">
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">{Tour.title}</h5>
                    <p className="card-text">{Tour.tour_picture}</p>
                    <p className="card-text">amount of people: {bookedTour.amountOfPeople}</p>
                    <p className="card-text">Date: {bookedTour.time}</p>
                    <Button
                        className="btn me-2 btn-danger"
                        onClick={() => removeBookedTour(Tour.tourID)}>
                        Delete
                    </Button>
                </div>
            </div>
        </div>
    );
}

export default Tour;
