<html>
    <title>Company Personal Page</title>
    <body>

        <a href="logout">Logout!</a>
        <br>

        <h1>add company data as JSON</h1>
        <h1>${flag}</h1>
        <form method="post" action="addCompanyData">
            <input type="text" name="data">
            <input type="submit">
        </form>
        <br>
        <h1> delete company data and delete company</h1>
        <h1>${remove}</h1>
        <form method="post" action="delete">
            <input type="submit">
        </form>
        <br>
        <h1>Update company Password</h1>
        <h1>${update}</h1>
        <form method="post" action="update">
            <input type="password" name="password">
            <input type="submit" >

        </form>

    </body>
</html>