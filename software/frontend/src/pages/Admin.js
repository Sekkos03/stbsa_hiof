import React, {useEffect, useState} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import HeaderAdmin from "../components/header/HeaderAdmin";
import Tour from "../components/Tour";
import axios from "axios";

function Admin() {

    const [BookedTours, setBookedTours] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/getAllBookedTours")
            .then(response => {
                setBookedTours(response.data);
            })
            .catch(error => {
                console.error(error);
            });
        }, []);

    return (
        <>
            <HeaderAdmin/>
            <div className="container">
                <div className="h1" style={{ marginBottom: '5vh' }}>All Booked Tours</div>
                <div className="row">
                    {BookedTours.map((BookedTour) => (
                        <Tour key={BookedTour.bookedTourID} bookedTour={BookedTour} />
                    ))}
                </div>
            </div>
        </>
    )
}

export default Admin;