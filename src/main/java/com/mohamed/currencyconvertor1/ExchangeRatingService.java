package com.mohamed.currencyconvertor1;

public class ExchangeRatingService {

    public double getConvertedAmount(ExchangeRatingRequest request){
        ExchangeRatingClient exchangeRatingClient = new ExchangeRatingClient();
        double exchangeRate = exchangeRatingClient.fetchExchangeRate(request.baseCode(), request.targetCode());
        return exchangeRate * Double.parseDouble(request.amount());
    }
}
