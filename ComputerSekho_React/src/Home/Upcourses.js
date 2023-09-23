import React, { useState, useEffect } from "react";
import { Button, Col } from "react-bootstrap";
import Table from "react-bootstrap/Table";
import "../CSS/Home.css"

// import 'react-bootstrap'
function Upcourses() {

  const [upcomingBatches, setUpcomingBatches] = useState([]);

  useEffect(() => {
    // Fetch data from the API
    fetch("http://localhost:8080/api/batch")
      .then((response) => response.json())
      .then((data) => {
        setUpcomingBatches(data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  // const formatDate = (dateTimeString) => {
  //   const date = new Date(dateTimeString);
  //   return date.toISOString().split("T")[0]; // Get only the date part
  // };

  const formatDate = (dateTimeString) => {
    const options = { year: "numeric", month: "long", day: "numeric" };
    return new Date(dateTimeString).toLocaleDateString(undefined, options);
  };

    return (
      <div>
      <h2>Upcoming Batches</h2>
     
    <br/><br/><br/>
      <Col md="11" style={{marginLeft:"40px"}}>
      <Table striped bordered hover  variant="dark"   responsive>
        <thead>
          <tr>
            <th>Batch ID</th>
            <th>Batch Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Final Presentation Date</th>
            <th>Fee</th>
          </tr>
        </thead>
        <tbody>
          {upcomingBatches.map((batch) => (
            <tr key={batch.batch_id}>
              <td>{batch.batch_id}</td>
              <td>{batch.batch_name}</td>
              <td>{formatDate(batch.batch_start_date)}</td>
              <td>{formatDate(batch.batch_end_date)}</td>
              <td>{formatDate(batch.final_presentation_date)}</td>
              <td>{batch.batch_fees}</td>
            </tr>
          ))}
        </tbody>
      </Table>
      </Col>
    </div>
    )
}

export default Upcourses
