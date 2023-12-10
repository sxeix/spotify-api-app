package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtistResponse {
    @SerializedName("artists")
    List<ArtistWithGenre> artists;
}
