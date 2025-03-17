import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const LoginPage = () =>{
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const response = await axios.post("http://localhost:8080/api/users/login",
                { username, password },
                {
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            );
            localStorage.setItem("token", response.data.token);
            navigate("/chat");
        } catch (error) {
            console.error("Login error:", error.response ? error.response.data : error.message);
            alert("Login failed!");
        }
    };

    return (
        <div>
            <h1>Login Page</h1>
            <input type="text" placeholder="Username" onChange={(e) => setUsername(e.target.value)} />
            <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleLogin}>Log in</button>
        </div>

    );
};

export default LoginPage;