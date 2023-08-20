package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Response object for the playlist items endpoint
 */
@Getter
@Setter
public class PlaylistItems {

    @SerializedName("href")
    private String href;

    @SerializedName("limit")
    private String limit;

    @SerializedName("next")
    private String next;

    @SerializedName("offset")
    private String offset;

    @SerializedName("previous")
    private String previous;

    @SerializedName("total")
    private String total;

    @SerializedName("items")
    private PlaylistTrackObject[] items;

}
