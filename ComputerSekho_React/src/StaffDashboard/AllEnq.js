import React, { useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import { Container, Row, Col } from "reactstrap";
import Dashoption from "../Login/dashoption";
import BootstrapTable from 'react-bootstrap-table-next';
import filterFactory, { textFilter } from 'react-bootstrap-table2-filter'; // Import filterFactory and textFilter

// Import your custom CSS file
import '../CSS/Style.css';

export function AllEnq(props) {
  const [enquiries, setEnquiries] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/getenq")
      .then((res) => {
        if (!res.ok) {
          throw new Error("Network response was not ok");
        }
        return res.json();
      })
      .then((result) => {
        setEnquiries(result);
      })
      .catch((error) => {
        console.error("Error fetching enquiries:", error);
      });
  }, []);

  const columns = [
    {
      dataField: 'enquiry_id',
      text: 'Enq Id',
      sort: true,
      headerStyle: { width: '50px' },
    },
    {
      dataField: 'enquirer_name',
      text: 'Name',
      filter: textFilter(),
    },
    {
      dataField: 'enquirer_mobile',
      text: 'Mobile',
      sort: true,
      headerStyle: { width: '150px' },
    },
    {
      dataField: 'enquirer_email_id',
      text: 'Email',
    },
    {
      dataField: 'enquirer_query',
      text: 'Query',
    },
    {
      dataField: 'followup_msg',
      text: 'Followup message',
    },
    {
      dataField: 'closure_reason',
      text: 'Closure reason',
    },
    {
      dataField: 'enquiry_processed_flag',
      text: 'Status',
      formatter: (cellContent, row) => (
        <div
          className={row.enquiry_processed_flag ? "status-close" : "status-open"}
        >
          {row.enquiry_processed_flag ? "Close" : "Open"}
        </div>
      ),
      sort: true,
      headerStyle: { width: '80px' },
    },
    {
      dataField: 'actions',
      text: 'Call',
      formatter: (cellContent, row) => (
        <a href={"/call/" + row.enquiry_id}>
          <Button variant="secondary">Call</Button>
        </a>
      ),
      sort: true,
      headerStyle: { width: '80px' },
    },
    {
      dataField: 'actions',
      text: 'Register',
      formatter: (cellContent, row) => (
        <a href={"/newreg/" + row.enquiry_id}>
          <Button variant="secondary">Register</Button>
        </a>
      ),
      sort: true,
      headerStyle: { width: '100px' },
    },
  ];

  return (
    <>
      <Dashoption />
      <Container fluid>
        <Row>
          <Col md="12">
            <div className="table-responsive">
              <br />
              <h2 align="center">Enquiry List</h2>
              <br />
              <BootstrapTable
                striped
                bordered
                hover
                keyField="enquiry_id"
                data={enquiries}
                columns={columns}
                filter={filterFactory()}
                rowStyle={(row, rowIndex) => ({
                  backgroundColor: row.enquiry_processed_flag
                    ? "#f44336" // Red for close status
                    : "#4caf50", // Green for open status
                  color: "white",
                })}
              />
            </div>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default AllEnq;
