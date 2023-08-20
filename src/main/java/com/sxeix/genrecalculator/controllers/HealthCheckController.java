package com.sxeix.genrecalculator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Health check controller
 */
@RestController
public class HealthCheckController {

    /**
     * Health check endpoint
     *
     * @return message
     */
    @GetMapping(value = "/health-check")
    public String healthCheck() {
        return "Spotify genre calculator now running";
    }

}