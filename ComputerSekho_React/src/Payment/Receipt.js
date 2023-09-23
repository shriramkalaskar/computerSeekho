import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './Payment.css';
import './Receipt.css';

function Receipt() {
  const { student_id } = useParams();
  const [studentData, setStudentData] = useState({});
  const [courseData, setCourseData] = useState({});
  const [batchData, setBatchData] = useState({});
  const [paymentData, setPaymentData] = useState([]);
  const [totalFees, setTotalFees] = useState(0); // Define totalFees state variable

  useEffect(() => {
    // Fetch student data based on student_id
    fetch(`http://localhost:8080/api/studentbyid/${student_id}`)
      .then((response) => response.json())
      .then((data) => {
        setStudentData(data);

        // Fetch course data using studentData.course_id
        fetch(`http://localhost:8080/api/CourseById/${data.course_id}`)
          .then((courseResponse) => courseResponse.json())
          .then((courseData) => {
            setCourseData(courseData);
          })
          .catch((courseError) => {
            console.error('Error fetching course data:', courseError);
          });

        // Fetch batch data using studentData.batch_id
        fetch(`http://localhost:8080/api/batch/${data.batch_id}`)
          .then((batchResponse) => batchResponse.json())
          .then((batchData) => {
            setBatchData(batchData);
          })
          .catch((batchError) => {
            console.error('Error fetching batch data:', batchError);
          });
      })
      .catch((error) => {
        console.error('Error fetching student data:', error);
      });

    // Fetch payment data based on student_id
    fetch(`http://localhost:8080/api/getPaymentbystdID/${student_id}`)
      .then((response) => response.json())
      .then((data) => {
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

  const handlePrint = () => {
    window.print();
  };

  return (
    <div className="receipt">
      <h2>Fee Invoice</h2>
      <div>
        <h4>Student Information</h4>
        <p>Student Name: {studentData.student_name}</p>
        <p>Student ID: {studentData.student_id}</p>
      </div>

      <div>
        <h4>Course Information</h4>
        <p>Course Name: {courseData.course_name}</p>
      </div>

      <div>
        <h4>Batch Information</h4>
        <p>Batch Name: {batchData.batch_name}</p>
      </div>

      <h4>Payment Details</h4>
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
      <table className="payment-table">
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
      <button onClick={handlePrint}>Print Receipt</button>
    </div>
  );
}

export default Receipt;