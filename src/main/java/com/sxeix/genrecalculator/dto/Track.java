package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

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
}
