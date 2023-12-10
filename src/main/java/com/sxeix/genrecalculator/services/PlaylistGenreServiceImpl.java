package com.sxeix.genrecalculator.services;


import com.sxeix.genrecalculator.dto.Artist;
import com.sxeix.genrecalculator.dto.PlaylistItems;
import com.sxeix.genrecalculator.dto.PlaylistTrackObject;
import com.sxeix.genrecalculator.dto.Track;
import com.sxeix.genrecalculator.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

        PlaylistItems tracks = spotifyApiService.getPlaylistItems(playlistId);

        List<String> artistIds = Arrays.stream(tracks.getItems())
                .map(PlaylistTrackObject::getTrack)
                .map(Track::getArtists)
                .flatMap(artists -> artists.stream().map(Artist::getUri).distinct())
                .distinct()
                .map(StringUtil::getIdFromURI)
                .toList();

        spotifyApiService.getArtists(artistIds);
        return tracks;
    }
}