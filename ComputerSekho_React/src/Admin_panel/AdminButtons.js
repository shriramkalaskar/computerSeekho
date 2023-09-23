// import Container from 'react-bootstrap/Container';

import { Link, NavLink, Navigate, Outlet } from 'react-router-dom';
import { Col, Button } from 'reactstrap';

function AdminButtons() {
    return (
        <>
            <Col md="12">
                <div className="button-container">

                    <Button  tag={Link} to="/showstaff">Staff</Button>
                    <Button  tag={Link} to="/courselist">Course</Button>
                    <Button  tag={Link} to="/enqlist">All Enquiry</Button>
                    <Button  tag={Link} to="/studlist">Students List</Button>

                </div>
            </Col>
        </>
    )
}

export default AdminButtons