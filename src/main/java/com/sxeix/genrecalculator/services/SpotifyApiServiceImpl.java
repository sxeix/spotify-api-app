package com.sxeix.genrecalculator.services;

import com.google.gson.Gson;
import com.sxeix.genrecalculator.caching.Cache;
import com.sxeix.genrecalculator.dto.ArtistResponse;
import com.sxeix.genrecalculator.dto.PlaylistItems;
import com.sxeix.genrecalculator.dto.TokenResponse;
import com.sxeix.genrecalculator.config.Properties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.sxeix.genrecalculator.constants.SpotifyAuthConstants.*;

/**
 * Spotify API service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SpotifyApiServiceImpl implements SpotifyApiService {

    private final HttpService httpService;
    private final Properties properties;
    private final Cache cache;

    /**
     * Get new access token and store in cache
     */
    @Override
    public void getAccessToken() {
        try {
            TokenResponse token = httpService.doPostAuth(String.format(CLIENT_CREDENTIALS_AUTH, properties.getSpotifyAuthUrl()));
            if (token != null) {
                cache.setApiToken(token);
                cache.setTokenLastRefreshed(new Date());
            }
        } catch (Exception e) {
            log.error("Failure to get token", e);
        }
    }

    /**
     * Get playlist items by playlist id
     *
     * @param playlistId the playlist id
     * @return the playlist items
     */
    @Override
    public PlaylistItems getPlaylistItems(String playlistId) {
        try {
            String url = String.format(PLAYLIST_ITEMS, properties.getSpotifyApiUrl(), playlistId);
            String response = httpService.doGet(url);
            return new Gson().fromJson(response, PlaylistItems.class);
        } catch (Exception e) {
            log.error("Failure to get playlist items", e);
        }
        return null;
    }

    @Override
    public ArtistResponse getArtists(List<String> ids) {
        try {
            String idsParam = String.join(",", ids);
            String url = String.format(ARTISTS, properties.getSpotifyApiUrl(), idsParam);
            String response = httpService.doGet(url);
            return new Gson().fromJson(response, ArtistResponse.class);
        } catch (Exception e) {
            log.error("Failure to get playlist items", e);
        }
        return null;
    }
}
