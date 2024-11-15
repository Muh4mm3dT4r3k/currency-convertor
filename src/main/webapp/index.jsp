<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Converter</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="converter-container">
    <h1>Currency Converter</h1>
    <form id="converter-form">
        <label for="amount">Amount</label>
        <input type="number" id="amount" placeholder="Enter amount">

        <label for="baseCode">From</label>
        <select id="baseCode">
            <option value="USD">USD</option>
            <option value="EUR">EUR</option>
            <option value="GBP">GBP</option>
            <option value="EGP">EGP</option>
            <!-- Add more currencies -->
        </select>

        <label for="targetCode">To</label>
        <select id="targetCode">
            <option value="USD">USD</option>
            <option value="EUR">EUR</option>
            <option value="GBP">GBP</option>
            <option value="EGP">EGP</option>
            <!-- Add more currencies -->
        </select>

        <button type="submit" id="convert-btn">Convert</button>
    </form>
    <div id="result-container">
        <p id="result"></p>
    </div>
</div>
<script src="js/script.js"></script>
</body>
</html>