package com.example.pocbatch.streams.enums;

public enum StreamName {
    PRICE_FIXED_LENGTH("price-with-fixed-length", ".txt"),
    PRICE_DELIMITED("price-with-delimited", ".txt"),
    PRICE_CSV("price-with-csv", ".csv");

    private String stream;
    private String extesion;

    StreamName(String stream, String extesion) {
        this.stream = stream;
        this.extesion = extesion;
    }

    public String getStream() {
        return stream;
    }

    public String getExtesion() {
        return extesion;
    }
}
