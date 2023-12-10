package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Artist dto item
 */
@Getter
@Setter
public class Artist {

    @SerializedName("name")
    private String name;

    @SerializedName("uri")
    private String uri;
}
