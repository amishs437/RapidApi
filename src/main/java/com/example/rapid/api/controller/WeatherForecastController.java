package com.example.rapid.api.controller;
import com.example.rapid.api.service.WeatherForecastService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("forecast")
public class WeatherForecastController {
    @Autowired
    private WeatherForecastService weatherForecastService;
    /**
     * Retrieves the hourly forecast data for a location by name.
     *
     * @param locationName the name of the location to retrieve the forecast for
     * @return a ResponseEntity containing the forecast data as a string in the response body, with an OK status code
     * @throws UnirestException if an error occurs while making the API call
     */
    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<?> getHourlyForecastByLocationName(@PathVariable String locationName)  throws UnirestException{
        try {
            HttpResponse<String> response = weatherForecastService.getHourlyForecastByLocationName(locationName);
            return ResponseEntity.ok(response.getBody().toString());
        } catch (IllegalArgumentException  | UnirestException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid location name.");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    /**
     * Retrieves a summary of the forecast data for a location by name.
     *
     * @param locationName the name of the location to retrieve the forecast summary for
     * @return a ResponseEntity containing the forecast summary data as a string in the response body, with an OK status code
     * @throws UnirestException if an error occurs while making the API call
     */
    @GetMapping("/summary/{locationName}")
    public ResponseEntity<String> getForecastSummaryByLocationName(@PathVariable String locationName) throws UnirestException {
        try {
            HttpResponse<String> response = weatherForecastService.getForecastSummaryByLocationName(locationName);
            return ResponseEntity.ok(response.getBody().toString());
        } catch (IllegalArgumentException  | UnirestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid location name.");
        }
    }
}
