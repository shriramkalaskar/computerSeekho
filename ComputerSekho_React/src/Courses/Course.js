import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Carousel from "react-bootstrap/Carousel";

export function Course() {
  const navigate = useNavigate();
  const [course, setCourse] = useState({});
  const { id } = useParams();

  {/*useEffect(() => {
    fetch("http://localhost:8080/api/CourseById/" + id)
      .then((res) => res.json())
      .then((result) => {
        setCourse(result);
      });
  }, [id]);*/}

  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>{course.course_name}</h1>
      <Carousel activeIndex={index} onSelect={handleSelect}>
        <Carousel.Item>
          <img
            src="/images/slide/1.jpg"
            alt="First slide"
            style={{ maxWidth: "100%", maxHeight: "100vh" }} // Set maximum width and height
          />
          <Carousel.Caption>
            <h3>'{course.course_name}'</h3>
            <div>{course.course_description}</div>
      <div>{course.course_syllabus}</div>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            src="/images/slide/2.jpg"
            alt="Second slide"
            style={{ maxWidth: "100%", maxHeight: "100vh" }} // Set maximum width and height
          />
          <Carousel.Caption>
            <h3>'{course.course_name}'</h3>
            <div>{course.course_description}</div>
      <div>{course.course_syllabus}</div>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            src="/images/slide/3.jpg"
            alt="Third slide"
            style={{ maxWidth: "100%", maxHeight: "100vh" }} // Set maximum width and height
          />
          <Carousel.Caption>
            <h3>'{course.course_name}'</h3>
            <p>
            <div>{course.course_description}</div>
      <div>{course.course_syllabus}</div>
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
      <br />
      <div>{course.course_description}</div>
      <div>{course.course_syllabus}</div>
      <br />
      <Button
        variant="primary"
        onClick={() => {
          navigate(-1);
        }}
      >
        Back
      </Button>
    </div>
  );
}

export default Course;
