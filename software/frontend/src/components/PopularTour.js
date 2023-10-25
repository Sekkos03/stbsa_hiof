import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Col, Row} from "react-bootstrap";
import {Link} from "react-router-dom";


function PopularTour() {

    const [tour, setTours] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/allTours')
            .then(response => response.json())
            .then(data => setTours(data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div className="container" style={{ marginBottom: '5px' }}>
            <div className="h1" style={{ marginBottom: '5vh' }}>Popular Tour City</div>
            <Row className="g-3">
                {tour.slice(0, 8).map((tour) => (
                    <Col key={tour.tourID} xs={12} sm={6} md={4} lg={3}>
                        <Link to={"Tours/"+ tour.tourID} style={{textDecoration: "none" }}>
                            <Card>
                                <Card.Img variant="top" src={tour.tour_picture} />
                                <Card.Body>
                                    <Card.Title>{tour.tourID}</Card.Title>
                                    <Card.Text>{tour.description.length > 100 ? tour.description.slice(0, 100) + "..." : tour.description}</Card.Text>
                                </Card.Body>
                            </Card>
                        </Link>
                    </Col>
                ))}
            </Row>
        </div>
    )

}

export default PopularTour;