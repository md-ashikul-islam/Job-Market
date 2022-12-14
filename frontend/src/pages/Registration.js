import React,{ useEffect, useState } from 'react';
import {signUp} from "../services/user-sevice"
import 'react-toastify/dist/ReactToastify.css';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBInput,
  MDBIcon,
  MDBCheckbox
}
from 'mdb-react-ui-kit';
import { useNavigate } from "react-router-dom";
import { ToastContainer,toast } from 'react-toastify';
import { getError } from '../utils';


// const initial = { name: "", email: "", password: ""};
function Registration() {
  const [data,setData] = useState({
    name:'',
    email:'',
    password:'',
    confirmPassword:'',

  })

  const [error,setError] = useState({
    errors:{},
    isError:false
  })


  const handleChange=(e,property)=>{
    setData({...data,[property]:e.target.value})
  }

  const submitForm=(e)=>{
    e.preventDefault()
  }

  // const [name, setName] = useState('');
  // const [email, setEmail] = useState('');
  // const [password, setPassword] = useState('');
  // const [confirmPassword, setConfirmPassword] = useState('');
  // const navigate = useNavigate();
  // const handleSubmit = async (e) => {
  //   e.preventDefault();
  //   if(password !== confirmPassword){
  //     toast.error('Passwords do not match', {
  //       position: "top-center",
  //       autoClose: 5000,
  //       hideProgressBar: false,
  //       closeOnClick: true,
  //       pauseOnHover: true,
  //       draggable: true,
  //       progress: undefined,
  //       theme: "light",
  //       });;
  //     return;
  //   }
  //   try{
  //   const form ={name,email,password
  //   }
  //   fetch("http://localhost:6969/api/users/", {
  //     method: "POST", // or 'PUT'
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify(form),
  //   })
  //     .then((response) => console.log(response))
  //     .then((data) => {
  //       console.log("Success:", data);
        
  //     })
  //     .catch((error) => {
  //       console.error("Error:", error);
  //     });
  //     toast.success('👌 Registration Successful!', {
  //       position: "top-center",
  //       autoClose: 1500,
  //       hideProgressBar: false,
  //       closeOnClick: true,
  //       pauseOnHover: true,
  //       draggable: true,
  //       progress: undefined,
  //       theme: "light",
  //       });
      
  //     setTimeout(() => {
  //       navigate("/login")
  //  }, 1600);
      
  //   }
  //   catch(err){
  //     toast.error(getError(err));
  //   }
  // };
  return (
    <MDBContainer fluid>

    <form autoComplete="off" onSubmit={submitForm}>
          <MDBRow>
            <MDBCol md='10' lg='6' className='order-2 order-lg-1 d-flex flex-column align-items-center'>

              <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

              <div className="d-flex flex-row align-items-center mb-4 ">
                <MDBIcon fas icon="user me-3" size='lg'/>
                <MDBInput onChange={(e)=>handleChange(e,'name')} value={data.name} label='Your Name' id='name' type='text' className='w-100'/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="envelope me-3" size='lg'/>
                <MDBInput onChange={(e)=>handleChange(e,'email')} value={data.email} label='Your Email' id='email' type='email'/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="lock me-3" size='lg'/>
                <MDBInput onChange={(e)=>handleChange(e,'password')} value={data.password} label='Password' id='password' type='password'/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="key me-3" size='lg'/>
                <MDBInput onChange={(e)=>handleChange(e,'confimPassword')} value={data.confirmPassword} label='Repeat your password' id='confirmPassword' type='password'/>
              </div>

              <div className='mb-4'>
                <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Subscribe if you are a noshu' />
              </div>

              <MDBBtn className='mb-4' size='lg' type='submit'>Register</MDBBtn>

            </MDBCol>

            {/* <MDBCol md='10' lg='6' className='order-1 order-lg-2 d-flex align-items-center'>
              <MDBCardImage src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp' fluid/>
            </MDBCol> */}

          </MDBRow>
          </form>
        <ToastContainer />
      

    </MDBContainer>
  );
}

export default Registration;