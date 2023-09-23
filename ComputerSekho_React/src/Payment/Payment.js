import React from 'react';
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom"
import { Container, Row, Col } from 'react-bootstrap';
//import './payment.css';

export  default function Payment() {
    
    const [payment , setPayment] =useState({});
    const {id} = useParams();

    useEffect(() => {
        fetch("http://localhost:8080/api/getPaymentbyID/"+id)
            .then(res => res.json())
            .then((result) => {setPayment(result); }
            );
    }, {});

    return(
        <div className="payment-details">
        <Container>
        <Row>
          <Col>
            <h2>Payment Details</h2>
            <p><strong>Payment ID:</strong> {payment.payment_id}</p>
            <p><strong>Transaction ID:</strong> {payment.payment_transaction_id}</p>
            <p><strong>Payment Date:</strong> {payment.payment_date}</p>
            <p><strong>Payment Done:</strong> {payment.payment_done ? "True" : "False"}</p>
            <p><strong>Payment Receipt Sent:</strong> {payment.payment_receipt_send ? "True" : "False"}</p>
            <p><strong>Payment Type:</strong> {payment.payment_type}</p>
            <p><strong>Amount:</strong> {payment.amount}</p>
          </Col>
        </Row>
      </Container>

    </div>
    )
}