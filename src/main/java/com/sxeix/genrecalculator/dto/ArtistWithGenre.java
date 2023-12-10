package com.sxeix.genrecalculator.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtistWithGenre {
    @SerializedName("genres")
    List<String> genres;
}
