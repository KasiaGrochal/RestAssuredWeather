package providers;

import config.Config;

import java.util.Map;


public class ParamProvider {

    protected static final Map<String, String> config = Config.getEnvironmentConfig().getProperties();
    protected static final String WEATHER = config.get("pathToWeather");
    protected static final String CITY = config.get("paramNameCityName");
    protected static final String ID = config.get("paramNameCityId");
    protected static final String LON = config.get("paramNameCityLon");
    protected static final String LAT = config.get("paramNameCityLat");
    protected static final String CITYNAME = config.get("bodyPathToCityName");
    protected static final String WIND = config.get("bodyPathToWind");
    protected static final String SPEED = config.get("bodyPathToSpeed");
    protected static final String COORD = config.get("bodyPathToCoord");
    protected static final String COD = config.get("bodyPathToCod");
    protected static final String BADREQUEST = config.get("badRequestCod");

}
