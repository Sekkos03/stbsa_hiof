import React from 'react'
import Header from "./components/header/Header";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/login/Login";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Header/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/guide" element={<Login/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
