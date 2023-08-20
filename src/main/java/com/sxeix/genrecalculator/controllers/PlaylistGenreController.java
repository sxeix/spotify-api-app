package com.sxeix.genrecalculator.controllers;

import com.sxeix.genrecalculator.annotations.TokenRequired;
import com.sxeix.genrecalculator.dto.PlaylistItems;
import com.sxeix.genrecalculator.services.PlaylistGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Playlist genre controller
 */
@RestController
@RequestMapping("playlist")
@RequiredArgsConstructor
public class PlaylistGenreController {

    private final PlaylistGenreService playlistGenreService;

    /**
     * Gets genre statistics for a given playlist
     *
     * @param playlistId the playlist id
     * @return playlist stats
     */
    @TokenRequired
    @GetMapping(value = "/genre-stats/{playlistId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlaylistItems getGenreStats(@PathVariable String playlistId) {
        return playlistGenreService.getGenreStats(playlistId);
    }

}
