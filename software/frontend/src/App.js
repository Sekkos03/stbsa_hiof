import React from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/login/Login";
import MainPage from "./pages/MainPage";
import GuideMainPage from "./pages/GuideMainPage";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/guide" element={<Login/>}/>
                <Route path="/GuideMainPage" element={<GuideMainPage/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
