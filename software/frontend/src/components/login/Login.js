import React from 'react';

function Login() {
    return (
        <div className="container h-100 text-center" >
            <h1 className="h3 mb-3 font-weight-normal">Login</h1>
            <div>
                <a href="http://localhost:3000/guideMainPage" className={"px-1 text-white"}><button className="btn btn-primary btn-lg"> Login as guide</button></a>
                <a href="http://localhost:3000/guideMainPage" className={"px-1 text-white"}><button className="btn btn-primary btn-lg">login as user</button></a>
            </div>
        </div>
    );
};

export default Login;
