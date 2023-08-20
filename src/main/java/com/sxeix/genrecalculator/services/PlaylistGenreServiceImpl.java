package com.sxeix.genrecalculator.services;


import com.sxeix.genrecalculator.dto.PlaylistItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Playlist genre service
 */
@Service
@RequiredArgsConstructor
public class PlaylistGenreServiceImpl implements PlaylistGenreService {

    private final SpotifyApiService spotifyApiService;

    /**
     * Get playlist items and generate genre statistics
     *
     * @param playlistId the playlist id
     * @return playlist genre statistics
     */
    @Override
    public PlaylistItems getGenreStats(String playlistId) {
        return spotifyApiService.getPlaylistItems(playlistId);
    }
}
