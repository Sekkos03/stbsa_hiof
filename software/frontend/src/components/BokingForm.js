import React, { useState, useEffect } from 'react';
import { Form, Button, Col, Container, Row } from 'react-bootstrap';

const BookingForm = ({maxPeople}) => {
    const [date, setDate] = useState('');
    const [time, setTime] = useState('');
    const [numberOfPeople, setNumberOfPeople] = useState(1);

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission here
    };

    return (
        <Container className="mt-4">
            <Row className="justify-content-center">
                <Col md={8}>
                    <Form onSubmit={handleSubmit}>
                        <h2 className="mb-4">Book a Tour</h2>
                        <Form.Group controlId="formDate">
                            <Form.Label>Select a Date</Form.Label>
                            <Form.Control
                                type="date"
                                value={date}
                                onChange={(e) => setDate(e.target.value)}
                                required
                            />
                        </Form.Group>
                        <Form.Group controlId="formTime">
                            <Form.Label>Select a Time</Form.Label>
                            <Form.Control
                                type="time"
                                value={time}
                                onChange={(e) => setTime(e.target.value)}
                                required
                            />
                        </Form.Group>
                        <Form.Group controlId="formNumberOfPeople">
                            <Form.Label>Number of People (up to {maxPeople})</Form.Label>
                            <Form.Control
                                type="number"
                                value={numberOfPeople}
                                onChange={(e) => setNumberOfPeople(e.target.value)}
                                required
                                min="1"
                                max={maxPeople} // Set the maximum value dynamically
                            />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Book Tour
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
};

export default BookingForm;
