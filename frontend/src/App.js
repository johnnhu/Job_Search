import { Routes, Route } from "react-router-dom";
import { ToastContainer } from 'react-toastify';

import Home from "./pages/Home";
import About from "./pages/About";
import Insights from "./pages/Insights";
import Entities from "./pages/Entities";

import Address from "./pages/entities/Address";
import Applicants from "./pages/entities/Applicants";
import ApplicationMade from "./pages/entities/ApplicationMade";
import CoopSupervisorWorksAt from "./pages/entities/CoopSupervisorWorksAt";
import Company from "./pages/entities/Company";
import Attends from "./pages/entities/Attends";
import HiringManager from "./pages/entities/HiringManager";
import University from "./pages/entities/University";
import SpecializationInfo from "./pages/entities/SpecializationInfo";
import SpecializationCredits from "./pages/entities/SpecializationCredits";
import Offers from "./pages/entities/Offers";
import JobPositionCompensation from "./pages/entities/JobPositionCompensation";
import JobPositionBelongsTo from "./pages/entities/JobPositionBelongsTo";

import './App.css';

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/insights" element={<Insights />} />
                <Route path="/entities" element={<Entities />} />

                <Route path="/entities/address" element={<Address />} />
                <Route path="/entities/applicants" element={<Applicants />} />
                <Route path="/entities/applicationMade" element={<ApplicationMade />} />
                <Route path="/entities/attends" element={<Attends />} />
                <Route path="/entities/company" element={<Company />} />
                <Route path="/entities/coopSupervisorWorksAt" element={<CoopSupervisorWorksAt />} />
                <Route path="/entities/hiringManager" element={<HiringManager />} />
                <Route path="/entities/jobPositionBelongsTo" element={<JobPositionBelongsTo />} />
                <Route path="/entities/jobPositionCompensation" element={<JobPositionCompensation />} />
                <Route path="/entities/offers" element={<Offers />} />
                <Route path="/entities/specializationCredits" element={<SpecializationCredits />} />
                <Route path="/entities/specializationInfo" element={<SpecializationInfo />} />
                <Route path="/entities/university" element={<University />} />
            </Routes>

            <ToastContainer />
        </>
    );
}

export default App;
