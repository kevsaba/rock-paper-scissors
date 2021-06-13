<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Rock-Paper-Scissors</title>
</head>
<body>

<div>
    <div>
        <h1 align="center">RESULTS OF ALL GAMES</h1>
        <div align="center">
            <table border="1">
                <thead>
                <tr>
                    <td>Total Rounds Played</td>
                    <td>Player 1 WINS</td>
                    <td>Player 2 WINS</td>
                    <td>DRAWS</td>
                </tr>
                </thead>
                <tr>
                    <td>${resultBoard.resultsBoard.roundsPlayed}</td>
                    <td>${resultBoard.resultsBoard.player1Wins}</td>
                    <td>${resultBoard.resultsBoard.player2Wins}</td>
                    <td>${resultBoard.resultsBoard.playerDraw}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
