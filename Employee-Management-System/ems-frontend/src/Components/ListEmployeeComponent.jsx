import React, { useEffect } from 'react'
import { useState } from 'react';
import { listEmployees, deleteEmployee } from '../Services/EmployeeService';
import { useNavigate } from 'react-router-dom';
const ListEmployeeComponent = () => {
    const [employee, setEmployees] = useState([]);
    useEffect(()=>{
      getAllEmployee();
    },
    []);

    const getAllEmployee=()=>{
      listEmployees().then((response)=>{
        setEmployees(response.data);
      }).catch(error=>{
        console.error();
      })
    }
    const navigator=useNavigate();
    const addNewEmployee=()=>{

      navigator('/add-employee')
    }
    const updateEmployee=(id)=>{
      navigator(`/update-employee/${id}`)
      
    }
    const deleteEmployeeById=(id)=> {
      console.log(id);
      if(id){
        deleteEmployee(id).then((response)=>{
          getAllEmployee();
          console.log(response.data)
        }).catch(error=>{
          console.error(error);
        });
      }
      navigator('/employees');
    }
  return (
    <div className='container'>
      <h2 className='text-center'>List of Employee</h2>
      <button className='btn btn-primary mb-2 active' onClick={addNewEmployee}>Add Employee</button>
      <table className='table table-striped table-bordered'>
        <thead>
            <tr>
                <th>Employee Id</th>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee Email Address</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            {
                employee.map(employee=>
                    <tr key={employee.id} >
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                        <td>
                          <button className='btn btn-info' onClick={()=> updateEmployee(employee.id)}>  Update</button>
                        </td>
                        <td>
                          <button className='btn btn-danger' onClick={()=> deleteEmployeeById(employee.id)}>  Delete</button>
                        </td>
                    </tr>
                    )
            }
        
        </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent
