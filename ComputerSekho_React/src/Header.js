import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import CourseDropdown from './Courses/CourseDropdown';
import './CSS/Header.css'; // Import your custom CSS file

function Header() {
  return (
    <Navbar sticky='top' expand="lg" className="custom-navbar">
      <Container>
        <Nav.Link href="/">
          <Navbar.Brand>
            <img src="/images/computer.png" alt="Logo" />
            <div className="logo-text">Computer Seekho</div> {/* Add the "Computer Seekho" text */}
          </Navbar.Brand>
        </Nav.Link>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="custom-nav">
            <Nav.Link href="/" className="custom-nav-link"> {/* Apply custom style to the link */}
              Home
            </Nav.Link>
            <Nav.Link href="About" className="custom-nav-link"> {/* Apply custom style to the link */}
              About Us
            </Nav.Link>
            <Nav.Link href="Courses" className="custom-nav-link"> {/* Apply custom style to the link */}
              Courses
            </Nav.Link>
            <Nav.Link href="Gallery" className="custom-nav-link"> {/* Apply custom style to the link */}
              Gallery
            </Nav.Link>
            <Nav.Link href="placement" className="custom-nav-link"> {/* Apply custom style to the link */}
              Placement
            </Nav.Link>
            <Nav.Link href="Contactus" className="custom-nav-link"> {/* Apply custom style to the link */}
              Contact Us
            </Nav.Link>
            <NavDropdown title="Login Panel" id="basic-nav-dropdown" className="custom-nav-link">
              <NavDropdown.Item href="StaffLogin">Staff Login</NavDropdown.Item>
              <NavDropdown.Item href="adminlogin">Admin Login</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;
