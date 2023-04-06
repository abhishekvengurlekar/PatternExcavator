<html>
    <title>User Page</title>
    <body>
         <a href="goToCompanyPersonalPage">Go to Company Personal Page</a>
         <br>
         <a href="logout">Logout!</a>
         <br>

         ${associations}
         ${frequentItemSets}
         ${interestingRules}
         <br>

        <h1>Get all the Strong Association Rules</h1>
        <form method="post" action="strongAssociationRules">
            Support:<input type="number" name="support" placeholder="support">
            Confidence:<input type="number" name="confidence" placeholder="confidence">
            <input type="submit" placeholder="mine">
        </form>
        <br>
        <h1>Get all the Interesting Rules</h1>
        <form method="post" action="interestingRules">
            Support:<input type="number" name="support" placeholder="support">
            Confidence:<input type="number" name="confidence" placeholder="confidence">
            <input type="submit" placeholder="Interesting Rules">
        </form>
        <br>
        <h1>Get all the Frequent ItemSets</h1>
        <form method="post" action="frequentItemSets">
            support:<input type="number" name="support" placeholder="support">
            <input type="submit" placeholder="Frequent Itemsets">
        </form>
        <br>
        <h1>Stock refill Sets</h1>
        ${hash}
        <form method="post" action="repurchasing">
           amount:<input type="number" name="amount" placeholder="amount">
           support:<input type="number" name="support" placeholder="support">
            <input type="submit" placeholder="Get Result">
        </form>

    </body>


</html>

