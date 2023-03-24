package com.example.rapid.api.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.example.rapid.api.constants.WeatherForecastConstants.*;
@Slf4j
@Service
public class WeatherForecastService {

    /**
     * Retrieves the hourly forecast data for a location by name.
     *
     * @param locationName the name of the location to retrieve the forecast for
     * @return a ResponseEntity containing the forecast data as a string in the response body, with an OK status code
     * @throws UnirestException if an error occurs while making the API call
     */
    public static HttpResponse<String> getHourlyForecastByLocationName(String locationName) throws UnirestException {
        String url = BASE_URL + "/" + encodeLocationName(locationName) + "/hourly/";
        log.info("Url:-"+ url);
        HttpResponse<String> response = Unirest.get(url)
                .header("X-RapidAPI-Key", RapidAPI_Key)
                .header("X-RapidAPI-Host", RapidAPI_Host)
                .asString();
        log.info("Response for getHourlyForecastByLocationName:- "+response.getBody());
        return response;

    }
    /**
     * Retrieves a summary of the forecast data for a location by name.
     *
     * @param locationName the name of the location to retrieve the forecast summary for
     * @return a ResponseEntity containing the forecast summary data as a string in the response body, with an OK status code
     * @throws UnirestException if an error occurs while making the API call
     */
    public static  HttpResponse<String> getForecastSummaryByLocationName(String locationName) throws UnirestException {
        String url = BASE_URL + "/" + encodeLocationName(locationName) + "/summary/";
        HttpResponse<String> response = Unirest.get(url)
                .header("X-RapidAPI-Key", RapidAPI_Key)
                .header("X-RapidAPI-Host", RapidAPI_Host)
                .asString();
              log.info("Response for getForecastSummaryByLocationName:- "+ response.getStatus()+response.getBody());
        return response;

    }

    /**
     * Encodes the specified location name using UTF-8 encoding.
     *
     * @param locationName the location name to encode
     * @return the encoded location name as a string
     * @throws RuntimeException if the location name cannot be encoded or incorrect.

     */
    public static String encodeLocationName(String locationName) {
        try {
            return URLEncoder.encode(locationName, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            log.error("Error in location Name" + locationName);
            throw new RuntimeException("Location not Found");
        }
    }
}



