import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useParams } from 'react-router-dom';

function PaymentForm() {
  const navigate = useNavigate();
  const [student, setStudent] = useState({});
  const [batch, setBatch] = useState({});
  const { enquiry_id, selectedBatchId } = useParams();
  const [payment, setPayment] = useState({
    student_id: -1,
    batch_fees: 0,
    fees_paid: '',
    payment_mode: 'UPI', // Default to UPI
    payment_date: new Date().toISOString().split('T')[0],
    payment_transaction_id: '', // Added for non-cash payments
  });

  useEffect(() => {
    // Fetch student data based on the enquiry_id parameter
    fetch(`http://localhost:8080/api/getbyenquiry_id/${enquiry_id}`)
      .then((response) => response.json())
      .then((data) => {
        setStudent(data);
        setPayment((prevPayment) => ({
          ...prevPayment,
          student_id: data[0].student_id,
        }));
      })
      .catch((error) => {
        console.error('Error fetching student data:', error);
      });
  }, [enquiry_id]);

  useEffect(() => {
    // Fetch batch data based on the selectedBatchId parameter
    if (selectedBatchId) {
      fetch(`http://localhost:8080/api/batch/${selectedBatchId}`)
        .then((batchResponse) => batchResponse.json())
        .then((batchData) => {
          setBatch(batchData);
          setPayment((prevPayment) => ({
            ...prevPayment,
            batch_fees: batchData.batch_fees,
          }));
        })
        .catch((batchError) => {
          console.error('Error fetching batch data:', batchError);
        });
    }
  }, [selectedBatchId]);

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Submit payment details to the backend
    try {
      const response = await fetch('http://localhost:8080/api/postPayment', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(payment),
      });

      if (response.ok) {
        // Payment successful
        const updateEnquiryResponse = await fetch(`http://localhost:8080/api/updateprocessflag/${enquiry_id}`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
        });

        if (updateEnquiryResponse.ok) {
          navigate("/allenq/");
        } else {
          console.error('Error updating enquiry status');
        }
      } else {
        console.error('Error processing payment');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleCancelPay = async () => {
    await fetch(`http://localhost:8080/api/deletestudbyid/${payment.student_id}`, {
      method: 'DELETE',
    });
    navigate("/allenq/");
  };

  return (
    <div className="container">
      <div className="card">
        <div className="card-header bg-primary text-white">
          <h2>Payment Form</h2>
        </div>
        <div className="card-body">
          <form onSubmit={handleSubmit}>
            {/* Display student and payment related fields */}
            <div className="mb-3">
              <label className="form-label">Student ID:</label>
              <input type="text" className="form-control" value={payment?.student_id} readOnly />
            </div>
            {/* Display total fees */}
            <div className="mb-3">
              <label className="form-label">Total Fees:</label>
              <input type="number" className="form-control" value={payment?.batch_fees} readOnly />
            </div>
            {/* Payment Amount */}
            <div className="mb-3">
              <label className="form-label">Payment Amount:</label>
              <input
                type="number"
                className="form-control"
                value={payment.fees_paid}
                onChange={(e) => setPayment({ ...payment, fees_paid: e.target.value })}
                required
              />
            </div>
            {/* Payment Method */}
            <div className="mb-3">
              <label className="form-label">Payment Mode:</label>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="radio"
                  value="UPI"
                  checked={payment.payment_mode === 'UPI'}
                  onChange={() => setPayment({ ...payment, payment_mode: 'UPI' })}
                  required
                />
                <label className="form-check-label">UPI</label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="radio"
                  value="Cash"
                  checked={payment.payment_mode === 'Cash'}
                  onChange={() => setPayment({ ...payment, payment_mode: 'Cash' })}
                  required
                />
                <label className="form-check-label">Cash</label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="radio"
                  value="Credit Card"
                  checked={payment.payment_mode === 'Credit Card'}
                  onChange={() => setPayment({ ...payment, payment_mode: 'Credit Card' })}
                  required
                />
                <label className="form-check-label">Credit Card</label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="radio"
                  value="Debit Card"
                  checked={payment.payment_mode === 'Debit Card'}
                  onChange={() => setPayment({ ...payment, payment_mode: 'Debit Card' })}
                  required
                />
                <label className="form-check-label">Debit Card</label>
              </div>
            </div>
            {/* Transaction ID for non-cash payments */}
            {payment.payment_mode !== 'Cash' && (
              <div className="mb-3">
                <label className="form-label">Transaction ID:</label>
                <input
                  type="text"
                  className="form-control"
                  value={payment.payment_transaction_id}
                  onChange={(e) => setPayment({ ...payment, payment_transaction_id: e.target.value })}
                  required
                />
              </div>
            )}
            {/* Payment Date */}
            <div className="mb-3">
              <label className="form-label">Payment Date:</label>
              <input
                type="date"
                className="form-control"
                value={payment.payment_date}
                onChange={(e) => setPayment({ ...payment, payment_date: e.target.value })}
                required
              />
            </div>
            {/* Other payment fields */}
            <button type="submit" className="btn btn-primary">Pay Now</button>
          </form>
          <button onClick={handleCancelPay} className="btn btn-danger">Cancel Payment</button>
        </div>
      </div>
    </div>
  );
}

export default PaymentForm;
