package hu.bme.aut.weatherinfo.network;

import hu.bme.aut.weatherinfo.model.WeatherData;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String ENDPOINT_ADDRESS = "http://api.openweathermap.org";
    private static final String APP_ID = "9466e34e489927baaa35663de0c1d2f4";

    private static NetworkManager instance;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    private Retrofit retrofit;
    private WeatherApi weatherApi;

    private NetworkManager() {
        retrofit = new Retrofit.Builder().baseUrl(ENDPOINT_ADDRESS).client(new OkHttpClient.Builder().build()).addConverterFactory(GsonConverterFactory.create()).build();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    public Call<WeatherData> getWeather(String city) {
        return weatherApi.getWeather(city, "metric", APP_ID);
    }
}