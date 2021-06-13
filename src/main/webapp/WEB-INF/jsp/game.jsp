<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Rock-Paper-Scissors</title>
</head>
<body>

<div>
    <div>
        <h1 align="center">ROCK - PAPER - SCISSORS</h1>
        <div align="center">
            <form:form action="playRound" method="get">
                <input type="submit" value="Play Round">
            </form:form>
        </div>
        <div align="center">
            <table border="1">
                <thead>
                <tr>
                    <td>Round #</td>
                    <td>Player 1</td>
                    <td>Player 2</td>
                    <td>Result</td>
                </tr>
                </thead>
                <c:forEach var="gameStat" items="${gameStats}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${gameStat.player1played}</td>
                        <td>${gameStat.player2played}</td>
                        <td>${gameStat.result}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div align="center">
            <form:form action="restartCounter" method="get">
                <input type="submit" value="Restart Game">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
