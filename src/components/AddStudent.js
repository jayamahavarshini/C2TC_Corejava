
// src/components/AddStudentPage.js

import React, { useState } from 'react';
import StudentService from '../services/StudentService';
import { useNavigate } from 'react-router-dom';

const AddStudentPage = () => {
    const [student, setStudent] = useState({
        firstName: '',
        lastName: '',
        email: '',
        dateOfBirth: '',
        department: ''
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setStudent({
            ...student,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        StudentService.createStudent(student).then(() => {
            navigate('/'); // Redirect back to the student list page after adding
        });
    };

    return (
        <div className="container">
            <h2>Add New Student</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>First Name</label>
                    <input
                        type="text"
                        name="firstName"
                        className="form-control"
                        value={student.firstName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Last Name</label>
                    <input
                        type="text"
                        name="lastName"
                        className="form-control"
                        value={student.lastName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Email</label>
                    <input
                        type="email"
                        name="email"
                        className="form-control"
                        value={student.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Date of Birth</label>
                    <input
                        type="date"
                        name="dateOfBirth"
                        className="form-control"
                        value={student.dateOfBirth}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Department</label>
                    <input
                        type="text"
                        name="department"
                        className="form-control"
                        value={student.department}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-success">
                    Add Student
                </button>
            </form>
        </div>
    );
};

export default AddStudentPage;
