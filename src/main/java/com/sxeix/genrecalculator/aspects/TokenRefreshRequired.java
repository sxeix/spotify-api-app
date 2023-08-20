package com.sxeix.genrecalculator.aspects;

import com.sxeix.genrecalculator.caching.Cache;
import com.sxeix.genrecalculator.dto.TokenResponse;
import com.sxeix.genrecalculator.services.SpotifyApiService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.sxeix.genrecalculator.util.DateTimeUtil.dateToSeconds;

/**
 * Refreshes token if required
 */
@Aspect
@Component
@RequiredArgsConstructor
public class TokenRefreshRequired {

    private final Cache cache;
    private final SpotifyApiService spotifyApiService;

    /**
     * Runs when annotation is applied to endpoint and will refresh the token if needed
     */
    @Before(" @annotation(com.sxeix.genrecalculator.annotations.TokenRequired)")
    public void checkRefreshToken() {
        TokenResponse currentToken = cache.getApiToken();
        Date lastRefreshed = cache.getTokenLastRefreshed();
        int tokenLifespan = currentToken.getExpiresIn();
        long currentTime = dateToSeconds(new Date());
        long expiryTime = dateToSeconds(lastRefreshed) + tokenLifespan;

        if (currentTime >= expiryTime) {
            spotifyApiService.getAccessToken();
        }
    }

}
