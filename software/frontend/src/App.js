import React, {useState} from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/login/Login";
import MainPage from "./pages/MainPage";
import GuideMainPage from "./pages/GuideMainPage";
import UserMainPage from "./pages/UserMainPage";
import ToursPage from "./pages/ToursPage";

function App() {


  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/guide" element={<Login/>}/>
                <Route path="/GuideMainPage" element={<GuideMainPage/>}/>
                <Route path="/UserMainPage" element={<UserMainPage/>}/>
                <Route path="UserMainPage/tours/:tourID" element={<ToursPage/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
