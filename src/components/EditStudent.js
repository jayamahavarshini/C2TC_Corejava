import React, { useEffect, useState } from 'react';
import StudentService from '../services/StudentService';
import { useNavigate, useParams } from 'react-router-dom';

const EditStudent = () => {
    const [student, setStudent] = useState({
        firstName: '',
        lastName: '',
        email: '',
        dateOfBirth: '',
        department: '',
    });

    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        StudentService.getStudentById(id).then((response) => {
            setStudent(response.data);
        });
    }, [id]);

    const handleChange = (e) => {
        setStudent({ ...student, [e.target.name]: e.target.value });
    };

    const updateStudent = (e) => {
        e.preventDefault();
        StudentService.updateStudent(id, student).then(() => {
            navigate('/');
        });
    };

    return (
        <div className="container">
            <div className="w-50 mx-auto shadow p-5">
                <h2 className="text-center mb-4">Edit Student</h2>
                <form onSubmit={updateStudent}>
                    <div className="form-group">
                        <label>First Name</label>
                        <input
                            type="text"
                            className="form-control"
                            name="firstName"
                            value={student.firstName}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Last Name</label>
                        <input
                            type="text"
                            className="form-control"
                            name="lastName"
                            value={student.lastName}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Email</label>
                        <input
                            type="email"
                            className="form-control"
                            name="email"
                            value={student.email}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Date of Birth</label>
                        <input
                            type="date"
                            className="form-control"
                            name="dateOfBirth"
                            value={student.dateOfBirth}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Department</label>
                        <input
                            type="text"
                            className="form-control"
                            name="department"
                            value={student.department}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <button className="btn btn-primary btn-block">Update Student</button>
                </form>
            </div>
        </div>
    );
};

export default EditStudent;
