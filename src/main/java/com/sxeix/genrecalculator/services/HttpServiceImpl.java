package com.sxeix.genrecalculator.services;

import com.google.gson.Gson;
import com.sxeix.genrecalculator.caching.Cache;
import com.sxeix.genrecalculator.dto.TokenResponse;
import com.sxeix.genrecalculator.config.Properties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

/**
 * Http service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class HttpServiceImpl implements HttpService {

    private final Properties properties;
    private final Cache cache;

    /**
     * Post request for token authentication
     *
     * @param url the api endpoint url
     * @return new token
     * @throws URISyntaxException   URI syntax exception
     * @throws IOException          IO exception
     * @throws InterruptedException Interrupted exception
     */
    @Override
    public TokenResponse doPostAuth(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header(HttpHeaders.AUTHORIZATION, String.format("Basic %s", generateBase64AuthString()))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), TokenResponse.class);
    }

    /**
     * Generic get request method
     *
     * @param url the api endpoint url
     * @return json string content
     * @throws URISyntaxException   URI syntax exception
     * @throws IOException          IO exception
     * @throws InterruptedException Interrupted exception
     */
    @Override
    public String doGet(String url) throws URISyntaxException, IOException, InterruptedException {
        String token = cache.getApiToken().getAccessToken();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /**
     * Generate basic token for getting new api token in spotify's expected format
     *
     * @return string for use in auth token
     */
    private String generateBase64AuthString() {
        String concatValues = String.format("%s:%s", properties.getSpotifyClientId(), properties.getSpotifyClientSecret());
        return new String(Base64.getEncoder().encode(concatValues.getBytes()));
    }
}
