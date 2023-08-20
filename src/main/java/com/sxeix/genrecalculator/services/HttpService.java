package com.sxeix.genrecalculator.services;

import com.sxeix.genrecalculator.dto.TokenResponse;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Http service interface
 */
public interface HttpService {
    TokenResponse doPostAuth(String url) throws URISyntaxException, IOException, InterruptedException;

    String doGet(String url) throws URISyntaxException, IOException, InterruptedException;
}
