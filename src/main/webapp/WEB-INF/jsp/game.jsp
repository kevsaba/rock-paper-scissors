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
                    <td>Player 1</td>
                    <td>Player 2</td>
                    <td>Result</td>
                </tr>
                </thead>
                <tr>
                    <td>${gameStats.player1played}</td>
                    <td>${gameStats.player2played}</td>
                    <td>${gameStats.result}</td>
                </tr>
            </table>
        </div>
        <div align="center">
            <label>Rounds Played</label>
            <div>${rounds}</div>
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
