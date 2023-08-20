package com.sxeix.genrecalculator.services;

import com.sxeix.genrecalculator.dto.PlaylistItems;

/**
 * Playlist genre interface
 */
public interface PlaylistGenreService {
    PlaylistItems getGenreStats(String playlistId);
}
