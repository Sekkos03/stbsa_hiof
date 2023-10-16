import React from 'react';
import { Carousel } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import bilde1 from './bilder/bilde1.jpg';
import bilde2 from '../bilder/bilde2.jpg';
import bilde3 from '.../bilder/bilde3.jpg';


function MainPage() {

    const carouselContainerStyle = {
        height: '30%', // Set the desired height (15% of viewport height)
        width: '100%', // Set the desired width (100%)
    };

    const imgStyle = {
        width: '100%', // Adjust this width as needed
        height: '30%', // Maintains aspect ratio
    };

    const carouselStyle = {
        width: '100%', // Adjust this width as needed
        height: '30%', // Maintains aspect ratio
    }

    return (
        <div style = {carouselContainerStyle}>
            <Carousel style={carouselStyle}>
                <Carousel.Item>
                    <img src={bilde1} alt="First Slide" style={imgStyle}/>
                    <Carousel.Caption>
                        <h3>First slide label</h3>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img src={bilde2} alt="First Slide" style={imgStyle}/>
                    <Carousel.Caption>
                        <h3>Second slide label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img src={bilde3} alt="First Slide" style={imgStyle}/>
                    <Carousel.Caption>
                        <h3>Third slide label</h3>
                        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </div>
    );
}

export default MainPage;

