import React, {useEffect, useRef, useState} from 'react';
import Tour from './Tour';
import axios from "axios";

function BookedTourList({User}) {

    const [BookedTours, setBookedTours] = useState([]);


    useEffect(() => {
        if (User.guideUsersID) {
            axios.get(`http://localhost:8080/getAllBookedTourForOneGuide/${User.guideUsersID}`)
                .then(response => {
                    setBookedTours(response.data);
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }, [User.guideUsersID]);

    return (
        <div className="container">
            <div className="h1" style={{ marginBottom: '5vh' }}>All Booked Tour</div>
            <div className="row">
                {BookedTours.map((BookedTour) => (
                    <Tour key={BookedTour.bookedTourID} bookedTour={BookedTour} />
                ))}
            </div>
        </div>
    );
}

export default BookedTourList;
