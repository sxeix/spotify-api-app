package com.sxeix.genrecalculator.services;

import com.sxeix.genrecalculator.dto.ArtistResponse;
import com.sxeix.genrecalculator.dto.PlaylistItems;

import java.util.List;

/**
 * Spotify API service interface
 */
public interface SpotifyApiService {
    void getAccessToken();
    PlaylistItems getPlaylistItems(String playlistId);
    ArtistResponse getArtists(List<String> ids);
}
