package com.tcs.certificacion.RetoTCSAPIREST.models;

public class TokenModel {
    private int expiresIn;
    private String accessToken;

    public int getExpiresIn() {

        return expiresIn;
    }

    public String getAccessToken()
    {
        return accessToken;
    }
}
