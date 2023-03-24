# RapidApi
#**RapidApiGetForecastSummaryByLocationName**

This API endpoint allows you to retrieve a summary of the weather forecast for a specific location. You can use this endpoint to get a quick overview of the weather conditions, including temperature, wind speed, humidity, and precipitation.

#**Parameters**

location: The name of the location you want to retrieve the forecast summary for. This parameter is required.

#**Headers**

x-rapidapi-host: The host name of the RapidAPI endpoint.
x-rapidapi-key: Your RapidAPI API key.

**#Response**

The response will be in JSON format and will contain the following information:

location:

code:"DE0004130"

timezone:"Europe/Berlin"

name:"Hamburg"

coordinates:

forecast:items:

forecastDate:"2019-02-07T10:00:00"

nextUpdate:"2019-02-07T10:00:00"

source:"w3Data"

point:"global"

#**RapidApiGetHourlyForecastByLocationName**

This API endpoint allows you to retrieve an hourly weather forecast for a specific location. You can use this endpoint to get a detailed breakdown of the weather conditions, including temperature, wind speed, humidity, and precipitation, for each hour of the day.

#**Parameters**

location: The name of the location you want to retrieve the forecast summary for. This parameter is required.

#**Headers**

x-rapidapi-host: The host name of the RapidAPI endpoint.

x-rapidapi-key: Your RapidAPI API key.

#**Response**

*The response will be in JSON format and will contain the following information:*

location:

code:"DE0004130"

timezone:"Europe/Berlin"

name:"Hamburg"

coordinates:

forecast:items:

forecastDate:"2019-02-07T10:00:00"

nextUpdate:"2019-02-07T10:00:00"

source:"w3Data"

point:"global"

