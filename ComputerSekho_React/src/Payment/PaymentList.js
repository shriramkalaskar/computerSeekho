import React, { useState, useEffect } from "react";
import { Payment } from "./Payment";
import { Link } from "react-router-dom";
import { Container, Table } from "react-bootstrap";
//import "../CSS/paymentlist.css";
import { Button } from "react-bootstrap";

export default function PaymentList() {
  const [payments, setPayments] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/getPayment")
      .then((res) => res.json())
      .then((result) => {
        setPayments(result);
       
      })
      .catch((error) => {
        console.error("Error fetching payment data:", error);
    
      });
  }, []);

  return (
    <div>
      <Container className="payment-list-container">
      <h2>Payment Data...</h2>
      <Button  to="/PaymentCreate" className="create-link" as={Link}>
        Create New Payment
        </Button>
      <br/>
      <br/>
      <Table striped bordered hover responsive>
        <thead>
          <tr>
            <th>Payment ID</th>
            <th>Transaction ID</th>
            <th>Date</th>
            <th>Done</th>
            <th>Receipt Sent</th>
            <th>Amount</th>
            <th>Type</th>
            <th>Details</th>
          </tr>
        </thead>
        <tbody>
          {payments.map((payment) => (
            <tr key={payment.payment_id}>
              <td>{payment.payment_id}</td>
              <td>{payment.payment_transaction_id}</td>
              <td>{payment.payment_date}</td>
              <td>{payment.payment_done ? "Yes" : "No"}</td>
              <td>{payment.payment_receipt_send ? "Yes" : "No"}</td>
              <td>{payment.amount}</td>
              <td>{payment.payment_type}</td>
              <td>
                <Link to={`/Payment/${payment.payment_id}`} className="details-link">
                  Display
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
      
    </div>
  );
}
