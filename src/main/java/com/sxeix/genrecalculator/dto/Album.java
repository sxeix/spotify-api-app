package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Album dto item
 */
@Getter
@Setter
public class Album {

    @SerializedName("name")
    private String name;

    @SerializedName("genres")
    private String[] genres;
}
