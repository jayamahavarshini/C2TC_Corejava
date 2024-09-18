import React, { useEffect, useState } from 'react';
import StudentService from '../services/StudentService';
import AddStudent from './AddStudent';

import { Link } from 'react-router-dom';

const StudentList = () => {
   const [students, setStudents] = useState([]);
    //const [isFormVisible, setFormVisible] = useState(false);

    

    useEffect(() => {
        StudentService.getStudents().then((response) => {
            fetchStudents();
            console.log(response.data);
            setStudents(response.data);

        });
    }, []);
    /*const toggleFormVisibility = () => {
        setFormVisible(!isFormVisible);
    };
    <button className="btn btn-primary mb-3" onClick={toggleFormVisibility}>
    {isFormVisible ? 'Close Form' : 'Add Student'}
</button>*/

     
   const fetchStudents = () => {
        StudentService.getStudents().then((res) => {
            setStudents(res.data);
        });
    };
    
    const handleStudentAdded = () => {
        fetchStudents(); // Refresh the student list after adding a new student
    };

    const deleteStudent = (id) => {
        StudentService.deleteStudent(id).then(() => {
            setStudents(students.filter(student => student.id !== id));
        });
    };

    return (
        <div className="container">
            <h2 className="text-center">Student List</h2>
            <Link to="/add-student" className="btn btn-primary mb-3">
                Add Student
            </Link>
            <table className="table table-striped">
           

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Date of Birth</th>
                        <th>Department</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {students.map(student => (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.email}</td>
                            <td>{student.dateOfBirth}</td>
                            <td>{student.department}</td>
                            <td>
                                <Link className="btn btn-info" to={`/edit-student/${student.id}`}>
                                    Edit
                                </Link>
                                <button className="btn btn-danger ml-2" onClick={() => deleteStudent(student.id)}>
                                    Delete
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};


export default StudentList;
