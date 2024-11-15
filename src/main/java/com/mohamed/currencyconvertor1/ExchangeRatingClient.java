package com.mohamed.currencyconvertor1;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class ExchangeRatingClient {

    public double fetchExchangeRate(String baseCode, String targetCode) {
        String url = String
                .format("https://v6.exchangerate-api.com/v6/c6ebf0ecd2c48db7245f2bca/pair/%s/%s", baseCode, targetCode);
        ExchangeRatingResponse exchangeRatingResponse;
        try (Client client = ClientBuilder.newClient()) {
            exchangeRatingResponse = client
                    .target(url)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(ExchangeRatingResponse.class);
        }

        return exchangeRatingResponse.getConversionRate();
    }
}
