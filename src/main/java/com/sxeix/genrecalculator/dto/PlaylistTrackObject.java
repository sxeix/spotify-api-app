package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Track object
 */
@Getter
@Setter
public class PlaylistTrackObject {
    @SerializedName("track")
    private Track track;
}
