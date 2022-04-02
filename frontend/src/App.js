import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Applicants from "./pages/Applicants";
import Insights from "./pages/Insights";
import './App.css';

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/applicants" element={<Applicants />} />
                <Route path="/insights" element={<Insights />} />
            </Routes>
        </>
    );
}

export default App;
