package com.sxeix.genrecalculator.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Start up service
 */
@Service
@RequiredArgsConstructor
public class StartupServiceImpl implements StartupService {

    private final SpotifyApiService spotifyApiService;

    /**
     * Connects to spotify api via getting new access token to store in cache
     */
    @PostConstruct
    @Override
    public void applicationConnect() {
        spotifyApiService.getAccessToken();
    }

}
