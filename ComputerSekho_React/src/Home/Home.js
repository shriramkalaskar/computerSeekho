import React from 'react';
import { Outlet } from 'react-router-dom';
import Upcourses from './Upcourses';
import Header from '../Header';
import Footer from '../Footer';
import "../CSS/Home.css"

function Home() {
    return (
        <>
            <div className="container-fluid">
                <div className="row">
                    <div className="col-md-12 text-center">
                        <img
                            src="images/education.jpg"
                            alt="Main"
                            className="img"
                        />
                    </div>
                </div>
            </div>
            <div className="container">
                <div className="row mt-5">
                    <div className="col-md-12 text-center">
                        
                    </div>
                </div>
                <Upcourses />
            </div>
        </>

    );
}

export default Home;
