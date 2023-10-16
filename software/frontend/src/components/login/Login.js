import React from 'react';

const Login = () => {
    return (
        <body className="text-center">
            <div className="container h-100">
                <h1 className="h3 mb-3 font-weight-normal">Login</h1>
                <div>
                    <a href="http://localhost:3000/guideMainPage" className={"px-1 text-white"}><button className="btn btn-primary btn-lg"> Login as guide</button></a>
                    <a href="http://localhost:3000/guideMainPage" className={"px-1 text-white"}><butto className="btn btn-primary btn-lg">login as user</butto></a>
                </div>
            </div>
        </body>
    );
};

export default Login;
