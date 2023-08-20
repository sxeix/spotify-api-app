package com.sxeix.genrecalculator.services;

import com.sxeix.genrecalculator.dto.PlaylistItems;

/**
 * Spotify API service interface
 */
public interface SpotifyApiService {
    void getAccessToken();
    PlaylistItems getPlaylistItems(String playlistId);
}
