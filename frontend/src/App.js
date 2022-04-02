import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Applicants from "./pages/Applicants";
import './App.css';

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/applicants" element={<Applicants />} />
            </Routes>
        </>
    );
}

export default App;
