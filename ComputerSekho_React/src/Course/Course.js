import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Image from "react-bootstrap/Image";
import Container from "react-bootstrap/Container";
import "./Course.css"; // Import the custom CSS file

export function Course() {
  const navigate = useNavigate();
  const [course, setCourse] = useState({});
  const { id } = useParams();

  useEffect(() => {
    fetch("http://localhost:8080/api/CourseById/" + id)
      .then((res) => res.json())
      .then((result) => {
        setCourse(result);
      });
  }, []);

  return (
    <Container className="course-container"> {/* Use Bootstrap Container */}
      <h1 className="course-title">{course.course_name}</h1>
      <Image
        src="https://images.unsplash.com/photo-1501504905252-473c47e087f8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1074&q=80"
        alt="image"
        fluid
        className="course-image" 
      />
      <br />
      <div className="course-description">{course.course_description}</div>
      <div className="course-syllabus">{course.course_syllabus}</div>
      <br />
      <Button
        variant="primary"
        onClick={() => {
          navigate(-1);
        }}
        className="back-button"
      >
        Back
      </Button>
    </Container>
  );
}

export default Course;
