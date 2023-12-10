package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Track object
 */
@Getter
@Setter
public class Track {

    @SerializedName("name")
    private String name;

    @SerializedName("album")
    private Album album;

    @SerializedName("artists")
    private List<Artist> artists;
}
