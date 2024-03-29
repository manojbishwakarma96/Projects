import React, { useEffect, useState } from 'react'
import { creatEmployee, getEmployee, updateEmployee } from '../Services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {
    const [firstName,setfirstname]=useState('');
    const [lastName,setlastname]=useState('');
    const [email,setemail]=useState('');
    const {id}=useParams();
    const [error,setError]=useState({
        firstName:'',
        lastName:'',
        email:''
})
const navigator=useNavigate();

useEffect(()=>{
    if(id){
        getEmployee(id).then((response)=>{
            setfirstname(response.data.firstName);
            setlastname(response.data.lastName);
            setemail(response.data.email)
        }).catch(error=>{
           console.error(error);
        })
    }
},[id])

const saveorUpdateEmployee=(e)=>{
       e.preventDefault();

        if(validateForm() ){
            const employee={firstName,lastName,email}
             console.log(employee);
            if (id) {
                updateEmployee(id, employee)
                .then((response)=>{
                     console.log(response.data);
                    navigator('/employees');
                }).catch(error=>{
                    console.error(error);
                })
               
            }
            else{
                creatEmployee(employee).then((response)=>{
                console.log(response.data);
                navigator('/employees');
            }).catch(error=>{
                console.error(error)
            })

            }
            
           
    }
}
    const validateForm=()=>{
        let valid=true;
        const errorsCopy={... error}
        if(firstName.trim()===''){
             errorsCopy.firstName='First name is requires';
              valid=false;
        }
        
        if(lastName.trim()===''){
           errorsCopy.lastName='Last name is required';
             valid=false;
        }
        
        if(email.trim()===''){
           errorsCopy.email='Email-Address is required';
            valid=false;
        }
        setError(errorsCopy); 
        return valid;

    }

    const pageTitle=()=>{
        if(id) {
                    return <h2 className='text-center'> Update Employee</h2>
        }
        else
        {
        return <h2 className='text-center'> Add Employee</h2>
        }


    }
  return (
    <div className='container'>
       
       <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                {pageTitle()}
                <div className='card-body'>
                    <form >
                        <div className='form-group mb-2'>
                        <label className='form-label'>First Name</label>
                        <input 
                        type="text"
                        placeholder='Enter the first name'
                        name='firstname'
                        value={firstName}
                        className={`form-control ${error.firstName? 'is-invalid': ''}`}
                        onChange={(e)=> setfirstname(e.target.value)}
                        />
                        {error.firstName && <div className='invalid-feedback'>{error.firstName}</div>}
                        </div>
                        <div className='form-group mb-2'>
                        <label className='form-label'>Last Name</label>
                        <input 
                        type="text"
                        placeholder='Enter the last name'
                        name='lastname'
                        value={lastName}
                        className={`form-control ${error.lastName? 'is-invalid': ''}`}
                        onChange={(e)=> setlastname(e.target.value)}
                        />
                        {error.lastName && <div className='invalid-feedback'>{error.lastName}</div>}
                        </div>
                        <div className='form-group mb-2'>
                        <label className='form-label'>Email-Address</label>
                        <input 
                        type="email"
                        placeholder='Enter the email-address'
                        name='lastname'
                        value={email}
                       className={`form-control ${error.email? 'is-invalid': ''}`}
                        onChange={(e)=>setemail(e.target.value)}
                        />
                        {error.email  && <div className='invalid-feedback'>{error.email}</div>}
                        </div>
                        <button className='btn btn-success' onClick={saveorUpdateEmployee}>Submit</button>
                    </form>
                </div>
            </div>
        </div> 
    </div>
  )
}

export default EmployeeComponent
