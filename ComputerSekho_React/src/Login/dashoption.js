import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import "../CSS/Dash.css";
import { Col, Button, Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';

function Dashoption() {
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState(''); // Track the selected option

  const toggleDropdown = () => {
    setDropdownOpen(!dropdownOpen);
  };

  const handleOptionSelect = (option) => {
    setSelectedOption(option);
    // You can add logic here to perform actions based on the selected option if needed
  };

  return (
    <>
      <Col md="12">
        <div className="button-container">
          <Dropdown isOpen={dropdownOpen} toggle={toggleDropdown}>
            <DropdownToggle caret>
              {selectedOption || 'Select Option'}
            </DropdownToggle>
            <DropdownMenu>
              <DropdownItem onClick={() => handleOptionSelect('Followups')}>
                <Link to="/followups">Followups</Link>
              </DropdownItem>
              <DropdownItem onClick={() => handleOptionSelect('Add Enquiry')}>
                <Link to="/addenq">Add Enquiry</Link>
              </DropdownItem>
              <DropdownItem onClick={() => handleOptionSelect('All Enquiry')}>
                <Link to="/allenq">All Enquiry</Link>
              </DropdownItem>
              {/* <DropdownItem onClick={() => handleOptionSelect('New Student')}>
                <Link to="/newreg">New Student</Link>
              </DropdownItem> */}
              <DropdownItem onClick={() => handleOptionSelect('Student List')}>
                <Link to="/studlist">Student List</Link>
              </DropdownItem>
              <DropdownItem onClick={() => handleOptionSelect('Placement')}>
                <Link to="/placerecord">Placement</Link>
              </DropdownItem>
              <DropdownItem onClick={() => handleOptionSelect('Batch')}>
                <Link to="/batch">Batch</Link>
              </DropdownItem>
              <DropdownItem onClick={() => handleOptionSelect('Payment')}>
                <Link to="/PaymentList">Payment</Link>
              </DropdownItem>
              <DropdownItem onClick={() => handleOptionSelect('Staff')}>
                <Link to="/allstaff">Staff</Link>
              </DropdownItem>
            </DropdownMenu>
          </Dropdown>
        </div>
      </Col>
    </>
  );
}

export default Dashoption;
