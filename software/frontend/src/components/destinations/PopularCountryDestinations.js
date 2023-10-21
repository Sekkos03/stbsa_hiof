import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Col, Row} from "react-bootstrap";
import picture1 from "../../pictures/picture1.jpg";
import '../../pages/MainPage.css';


function MainPageCountryDestination() {

    return(
    <div className="container" style={{marginBottom: "5vh"}}>
        <div className = "h1" style={{ marginBottom: '5vh' }}>Popular Tour Countries</div>
        <Row xs={1} md={4} className="g-3">
            {Array.from({ length: 8 }).map((_, idx) => <Col key={idx}>
                <Card>
                    <Card.Img variant="top" src = {picture1} />
                    <Card.Body>
                        <Card.Title>Card title</Card.Title>
                        <Card.Text>
                            This is a longer card with supporting text below as a natural
                            lead-in to additional content. This content is a little bit
                            longer.
                        </Card.Text>
                    </Card.Body>
                </Card>
            </Col>)}
        </Row>
    </div>
    )
}

export default MainPageCountryDestination;

