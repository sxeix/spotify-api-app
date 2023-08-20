package com.sxeix.genrecalculator.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Properties file
 */
@Configuration
@Getter
public class Properties {
    @Value("${spotify.client.id}")
    private String spotifyClientId;

    @Value("${spotify.client.secret}")
    private String spotifyClientSecret;

    @Value("${spotify.auth.url}")
    private String spotifyAuthUrl;

    @Value("${spotify.api.url}")
    private String spotifyApiUrl;
}
