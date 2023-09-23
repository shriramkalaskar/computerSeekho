import React, { useState, useEffect } from 'react';
import axios from 'axios';
import filterFactory, { textFilter } from 'react-bootstrap-table2-filter';
import paginationFactory from 'react-bootstrap-table2-paginator';
import { Button } from 'reactstrap';
import Dashoption from '../Login/dashoption';
import '../CSS/CustomTable.css';

const formatDate = (dateTimeString) => {
  const date = new Date(dateTimeString);
  return date.toISOString().split('T')[0];
};

const Bootstraptab1 = () => {
  const [enquiry, setEnquiry] = useState([]);
  const [filteredEnquiry, setFilteredEnquiry] = useState([]);
  const [enquirerNameFilter, setEnquirerNameFilter] = useState('');

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/getenq')
      .then((response) => {
        const openEnquiries = response.data.filter(
          (item) => !item.enquiry_processed_flag
        );
        setEnquiry(openEnquiries);
        setFilteredEnquiry(openEnquiries);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const queryParams = new URLSearchParams(window.location.search);
  const staffIdFromURL = queryParams.get('staff_id');

  const handleFilterChange = (filterValue) => {
    setEnquirerNameFilter(filterValue);

    const filteredData = enquiry.filter((row) =>
      row.enquirer_name.toLowerCase().includes(filterValue.toLowerCase())
    );
    setFilteredEnquiry(filteredData);
  };

  const columns = [
    {
      dataField: 'enquiry_id',
      text: 'Enq.Id',
      sort: true,
      headerStyle: { width: '50px' },
    },
    {
      dataField: 'enquirer_name',
      text: 'Enquirer Name',
      sort: true,
      filter: textFilter({
        onFilter: handleFilterChange, // Add text filter for enquirer name
        value: enquirerNameFilter, // Controlled filter value
      }),
    },
    {
      dataField: 'enquirer_mobile',
      text: 'Phone',
      sort: true,
      headerStyle: { width: '150px' },
    },
    {
      dataField: 'follow_up_date',
      text: 'Follow-up Date',
      formatter: formatDate,
      sort: true,
      headerStyle: { width: '140px' },
    },
    {
      dataField: 'enquirer_email_id',
      text: 'Email',
      sort: true,
    },
    {
      dataField: 'followup_msg',
      text: 'Followup Message',
      sort: true,
    },
    {
      dataField: 'staff_id',
      text: 'Staff Id',
      filter: textFilter({
        defaultValue: staffIdFromURL,
      }),
      headerStyle: { width: '80px' },
    },
    {
      dataField: 'actions',
      formatter: (cell, row) => (
        <a href={`/call/${row.enquiry_id}`}>
          <Button className="btn btn-primary call-button">Call</Button>
        </a>
      ),
    },
    {
      dataField: 'actions',
      formatter: (cell, row) => (
        <a href={`/newreg/${row.enquiry_id}`}>
          <Button className="btn btn-success register-button">Register</Button>
        </a>
      ),
    },
  ];

  return (
    <>
      <Dashoption />

      <h2 align="center">Followup Page</h2>
      <div className="container-fluid">
        <div className="row justify-content-center">
          <div className="col-md-10">
            <div className="card shadow">
              <div className="card-body">
                <div className="table-responsive">
                  {filteredEnquiry.length > 0 ? (
                    <>
                      <input
                        type="text"
                        placeholder="Search by Enquirer Name"
                        value={enquirerNameFilter}
                        onChange={(e) => handleFilterChange(e.target.value)}
                        className="form-control mb-2"
                      />
                      <table className="custom-table table table-striped table-bordered">
                        <thead>
                          <tr>
                            <th className="w-5">Enq.Id</th>
                            <th>Enquirer Name</th>
                            <th className="w-15">Phone</th>
                            <th className="w-15">Follow-up Date</th>
                            <th>Email</th>
                            <th>Followup Message</th>
                            <th className="w-10">Staff Id</th>
                            <th className="w-5">Call</th>
                            <th className="w-10">Register</th>
                          </tr>
                        </thead>
                        <tbody>
                          {filteredEnquiry.map((row) => (
                            <tr key={row.enquiry_id}>
                              <td>{row.enquiry_id}</td>
                              <td>{row.enquirer_name}</td>
                              <td>{row.enquirer_mobile}</td>
                              <td>{formatDate(row.follow_up_date)}</td>
                              <td>{row.enquirer_email_id}</td>
                              <td>{row.followup_msg}</td>
                              <td>{row.staff_id}</td>
                              <td>
                                <a href={`/call/${row.enquiry_id}`}>
                                  <Button className="btn btn-primary call-button">
                                    Call
                                  </Button>
                                </a>
                              </td>
                              <td>
                                <a href={`/newreg/${row.enquiry_id}`}>
                                  <Button className="btn btn-success register-button">
                                    Register
                                  </Button>
                                </a>
                              </td>
                            </tr>
                          ))}
                        </tbody>
                      </table>
                    </>
                  ) : (
                    <p>Loading data...</p>
                  )}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Bootstraptab1;
