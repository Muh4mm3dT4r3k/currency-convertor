package com.mohamed.currencyconvertor1;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/convert")
public class ExchangeRatingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String amount = request.getParameter("amount");
        String baseCode = request.getParameter("baseCode");
        String targetCode = request.getParameter("targetCode");
        ExchangeRatingRequest exchangeRatingRequest = new ExchangeRatingRequest(amount, baseCode, targetCode);
        processConversion(response, exchangeRatingRequest);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExchangeRatingRequest exchangeRatingRequest = objectMapper.readValue(request.getInputStream(), ExchangeRatingRequest.class);
        processConversion(response, exchangeRatingRequest);

    }

    private void processConversion(HttpServletResponse response, ExchangeRatingRequest exchangeRatingRequest) throws IOException {
        String error = validateInputs(exchangeRatingRequest);
        if (error != null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, error);
            return;
        }
        ExchangeRatingService exchangeRatingService = new ExchangeRatingService();
        double convertedAmount = exchangeRatingService.getConvertedAmount(exchangeRatingRequest);
        response.setContentType("application/json");
        response.getWriter().write("{\"convertedAmount\": "+ convertedAmount + "}");
    }

    private String validateInputs(ExchangeRatingRequest exchangeRatingRequest) {
        String amountStr = exchangeRatingRequest.amount();
        String baseCode = exchangeRatingRequest.baseCode();
        String targetCode = exchangeRatingRequest.targetCode();
        if (amountStr == null || baseCode == null || targetCode == null)
            return "Missing parameters";

        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0)
                return "Amount must be greater than zero";
        }catch (NumberFormatException exception) {
            return "Invalid amount";
        }

        if (baseCode.isEmpty() || targetCode.isEmpty())
            return "Currency codes cannot be empty";

        return null;
    }
}
