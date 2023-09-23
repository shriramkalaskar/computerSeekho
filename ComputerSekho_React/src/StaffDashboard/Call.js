import React, { useState, useEffect } from 'react';
import Dashoption from '../Login/dashoption';
import { useNavigate, useParams } from 'react-router-dom';
import { Label } from 'reactstrap';

import '../CSS/CallForm.css'; // Import your custom CSS file

function Call(props) {
  const { id } = useParams();
  const [enquiry, setEnquiry] = useState({
    enquirer_name: '',
    student_name: '',
    enquirer_mobile: '',
    enquirer_email_id: '',
    enquirer_address: '',
    enquirer_query: '',
    enquiry_date: new Date().toISOString().substring(0, 10),
    followup_msg: '',
    close_enquiry: 'no',
    closure_reason: '',
    enquiry_processed_flag: false,
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setEnquiry((values) => ({
      ...values,
      [name]: value,
    }));
  };

  let navigate = useNavigate();

  const handleCloseEnquiryChange = (event) => {
    const { name, value } = event.target;
    setEnquiry((values) => ({
      ...values,
      [name]: value,
      closure_reason: '',
      enquiry_processed_flag: value === 'yes' ? true : false,
    }));
  };

  const renderClosureReasonInput = () => {
    if (enquiry.close_enquiry === 'yes') {
      return (
        <div className="form-group">
          <label>Closure Reason</label>
          <input
            type="text"
            name="closure_reason"
            value={enquiry.closure_reason}
            onChange={handleChange}
            className="form-control"
          />
        </div>
      );
    }
    return null;
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch(`http://localhost:8080/api/update_enquiry/${id}`, {
        method: 'PUT',
        headers: { 'Content-type': 'application/json' },
        body: JSON.stringify(enquiry),
      });

      if (response.ok) {
        alert('Enquiry Submitted Successfully !');
        navigate('/allenq');
      } else {
        console.error('Failed to store enquiry');
      }
    } catch (error) {
      console.error('Error storing enquiry:', error);
    }
  };

  const fetchExistingEnquiryData = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/getById/${id}`);
      const existingEnquiryData = await response.json();

      setEnquiry(existingEnquiryData);
    } catch (error) {
      console.error('Error fetching existing enquiry data:', error);
    }
  };

  useEffect(() => {
    fetchExistingEnquiryData();
  }, [id]);

  return (
    <div className="container-fluid">
      <div className="row">
        <Dashoption />
        <div className="col-md-11">
          <div className="container">
            <h3 align="center">Enquiry Followup</h3>
            <div className="row">
              <div className="col-sm-5">
                <form onSubmit={handleSubmit} className="custom-form">
                  <div className="form-group">
                    <label>Enquirer Name</label>
                    <input
                      type="text"
                      name="enquirer_name"
                      value={enquiry.enquirer_name}
                      onChange={handleChange}
                      className="form-control"
                    />
                  </div>
                

<div className="form-group">
  <label>Mobile No.</label>
  <input
    type="text"
    name="enquirer_mobile"
    value={enquiry.enquirer_mobile}
    onChange={handleChange}
    className="form-control"
  />
</div>

<div className="form-group">
  <label>Student Query</label>
  <textarea
    rows="5"
    name="enquirer_query"
    value={enquiry.enquirer_query}
    onChange={handleChange}
    className="form-control"
    placeholder="Enter student's query here..."
  />
</div>

<div className="form-group">
  <label>Follow-up Message</label>
  <textarea
    rows="5"
    name="followup_msg"
    value={enquiry.followup_msg}
    onChange={handleChange}
    className="form-control"
    placeholder="Enter your follow-up message here..."
  />
</div>



                  {/* Add the rest of your form fields here using similar form-group components */}

                  <div className="radio-group">
                    <label>Do you want to close enquiry?</label>
                    <div className="form-check">
                      <input
                        type="radio"
                        className="form-check-input"
                        label="Yes"
                        name="close_enquiry"
                        value="yes"
                        checked={enquiry.close_enquiry === 'yes'}
                        onChange={handleCloseEnquiryChange}
                      />
                      <label className="form-check-label">Yes</label>
                    </div>
                    <div className="form-check">
                      <input
                        type="radio"
                        className="form-check-input"
                        label="No"
                        name="close_enquiry"
                        value="no"
                        checked={enquiry.close_enquiry === 'no'}
                        onChange={handleCloseEnquiryChange}
                      />
                      <label className="form-check-label">No</label>
                    </div>
                  </div>
                  {renderClosureReasonInput()}
                  <button type="submit" className="custom-submit-button">
                    Submit
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Call;
