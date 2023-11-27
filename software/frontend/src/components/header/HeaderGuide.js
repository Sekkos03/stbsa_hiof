import React from 'react';
import Button from "react-bootstrap/button";
import {Link} from "react-router-dom";

function Header({User}) {

    return (
        <header className="p-3 bg-dark text-white">
            <div className="container">
                <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/GuideMainPage" className="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <svg className="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlinkHref="#bootstrap"></use></svg>
                    </a>




                    <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <Link to={"http://localhost:3000/Guide/" + User.guideUsersID + "/GuideMainPage"} style={{ textDecoration: 'none' }}>
                            <li className="nav-link px-2 text-secondary">Home</li>
                        </Link>

                        <Link to={"http://localhost:3000/Guide/" + User.guideUsersID + "/NewTour"} style={{ textDecoration: 'none' }}>
                            <li className="nav-link px-2 text-secondary">Opprett ny Tour</li>
                        </Link>
                    </ul>

                    <form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                        <input type="search" className="form-control form-control-dark" placeholder="Search..." aria-label="Search" />
                    </form>

                    <div className="text-end">
                        <Link to={"/user/" + "/Shoppingcart"}>
                        <i className="bi bi-gear"></i>
                        </Link>
                        <span className="text-white me-3">Welcome, {User.firstName}</span>
                        <Link to={"http://localhost:3000/"}>
                            <Button className="btn btn-secondary" >
                                Log out
                            </Button>
                        </Link>
                    </div>
                </div>
            </div>
        </header>
    );
}

export default Header;
