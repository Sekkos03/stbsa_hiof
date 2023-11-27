import React from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/login/Login";
import MainPage from "./pages/MainPage";
import GuideMainPage from "./pages/GuideMainPage";
import 'bootstrap/dist/css/bootstrap.min.css';
import ToursPage from "./pages/ToursPage";
import Shoppingcart from "./pages/Shoppingcart";
import MakeNewTour from "./pages/MakeNewTour";

function App() {


  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/guide" element={<Login/>}/>
                <Route path="/user/:UserID" element={<MainPage/>} />
                <Route path="/user/:UserID/tours/:tourID" element={<ToursPage/>}/>
                <Route path="/user/:UserID/Shoppingcart" element={<Shoppingcart/>}/>
                <Route path="/Guide/:GuideID/GuideMainPage" element={<GuideMainPage/>}/>
                <Route path="/Guide/:GuideID/NewTour" element={<MakeNewTour/>}/>
                <Route path="/Admin" element={<Admin/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
