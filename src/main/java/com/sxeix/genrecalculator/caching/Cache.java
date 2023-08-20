package com.sxeix.genrecalculator.caching;

import com.sxeix.genrecalculator.dto.TokenResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Cached data for usage around application
 */
@Configuration
@EnableCaching
@Getter
@Setter
public class Cache {
    private TokenResponse apiToken = null;
    private Date tokenLastRefreshed = null;
}
