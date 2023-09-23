import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import '../CSS/Payment.css';

function PaymentEdit() {
  const { student_id } = useParams();
  const [paymentData, setPaymentData] = useState([]);
  const [totalFees, setTotalFees] = useState(0);

  useEffect(() => {
    // Fetch payment records for the specified student_id
    fetch(`http://localhost:8080/api/getPaymentbystdID/${student_id}`)
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setPaymentData(data);

        // Calculate the total fees
        const calculatedTotalFees = data.reduce(
          (total, paymentRecord) => total + paymentRecord.fees_paid,
          0
        );
        setTotalFees(calculatedTotalFees);
      })
      .catch((error) => {
        console.error('Error fetching payment data:', error);
      });
  }, [student_id]);

  return (
    <div>
      <h2>Payment Details</h2>
      <br /><br />
      <div>
        <label>Total Batch Fees:</label>
        <input type="text" value={paymentData[0]?.batch_fees} readOnly />
      </div>
      <label>Fees Paid:</label>
      <input
        type="text"
        value={totalFees}
        readOnly
        className={totalFees === paymentData[0]?.batch_fees ? 'green-text' : 'red-text'}
      />
      <div>
        <label>Remaining Fees:</label>
        <input type="text"
          value={paymentData[0]?.batch_fees - totalFees}
          readOnly
          className={paymentData[0]?.batch_fees - totalFees > 0 ? 'green-text' : 'red-text'} />
      </div>
      <br />
      <div className="card">
        <div className="card-body">
          <h3 className="card-title">Payment Records</h3>
          <div className="table-responsive">
            <table className="table table-bordered table-striped custom-table">
              <thead>
                <tr>
                  <th>Payment ID</th>
                  <th>Transaction ID</th>
                  <th>Payment Mode</th>
                  <th>Payment Date</th>
                  <th>Paid Fees</th>
                </tr>
              </thead>
              <tbody>
                {paymentData.map((paymentRecord) => (
                  <tr key={paymentRecord.payment_id}>
                    <td>{paymentRecord.payment_id}</td>
                    <td>{paymentRecord.payment_transaction_id}</td>
                    <td>{paymentRecord.payment_mode}</td>
                    <td>{new Date(paymentRecord.payment_date).toLocaleDateString()}</td>
                    <td>{paymentRecord.fees_paid}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <br />
      <br />
      {paymentData[0]?.batch_fees - totalFees > 0 && (
        <Link to={`/newpay/${student_id}/${paymentData[0]?.batch_fees}`} className="btn btn-primary btn-lg">
          Add Payment
        </Link>
      )}
      <br /><br />
      <Link to={`/rec/${student_id}`} className="btn btn-success btn-lg">
        Print Receipt
      </Link>
      <br />
      <br />
      <br />
    </div>
  );
}

export default PaymentEdit;
