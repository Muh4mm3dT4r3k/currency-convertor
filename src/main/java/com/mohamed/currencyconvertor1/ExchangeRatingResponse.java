package com.mohamed.currencyconvertor1;

import jakarta.json.bind.annotation.JsonbProperty;

public class ExchangeRatingResponse {
    private String result;
    @JsonbProperty("time_last_update_utc")
    private String timeLastUpdateUtc;
    @JsonbProperty("time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonbProperty("base_code")
    private String baseCode;
    @JsonbProperty("target_code")
    private String targetCode;
    @JsonbProperty("conversion_rate")
    private double conversionRate;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
        this.timeLastUpdateUtc = timeLastUpdateUtc;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public void setTimeNextUpdateUtc(String timeNextUpdateUtc) {
        this.timeNextUpdateUtc = timeNextUpdateUtc;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "ExchangeRatingResponse{" +
                "result='" + result + '\'' +
                ", timeLastUpdateUtc='" + timeLastUpdateUtc + '\'' +
                ", timeNextUpdateUtc='" + timeNextUpdateUtc + '\'' +
                ", baseCode='" + baseCode + '\'' +
                ", targetCode='" + targetCode + '\'' +
                ", conversionRate='" + conversionRate + '\'' +
                '}';
    }
}
