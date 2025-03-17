import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const RegisterPage = () =>{
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");


    const handleRegister = async (e) =>{
    e.preventDefault();

    try{
    const response = await fetch(`http://localhost:8080/api/users/register?username=${username}&password=${password}`, {
        method: "POST",
        headers: {
        "Content-Type": "application/json",
    },
    });
    if(!response.ok){
        throw new Error("Registration failed!");
    }
    alert("Registration successful");

    } catch(err){
        alert('Registration error!');
    }

    };

     return (
        <div>
          <h2>Rejestracja</h2>
          <form onSubmit={handleRegister}>
            <input type="text" placeholder="Login" value={username} onChange={(e) => setUsername(e.target.value)} />
            <input type="password" placeholder="Hasło" value={password} onChange={(e) => setPassword(e.target.value)} />
            <button type="submit">Zarejestruj</button>
          </form>
        </div>
      );
    }

    export default RegisterPage;