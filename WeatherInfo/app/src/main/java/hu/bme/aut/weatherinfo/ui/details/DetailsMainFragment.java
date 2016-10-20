package hu.bme.aut.weatherinfo.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import hu.bme.aut.weatherinfo.R;
import hu.bme.aut.weatherinfo.model.Weather;

public class DetailsMainFragment extends Fragment {
    private TextView tvMain;
    private TextView tvDescription;
    private ImageView ivIcon;

    private WeatherDataHolder weatherDataHolder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof WeatherDataHolder) {
            weatherDataHolder = (WeatherDataHolder) getActivity();
        } else {
            throw new RuntimeException("Activity must implement WeatherDataHolder interface!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_main, container, false);
        tvMain = (TextView) view.findViewById(R.id.tvMain);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
        if (weatherDataHolder.getWeatherData() != null) {
            displayWeatherData();
        }
        return view;
    }

    private void displayWeatherData() {
        Weather weather = weatherDataHolder.getWeatherData().weather.get(0);
        tvMain.setText(weather.main);
        tvDescription.setText(weather.description);
        Glide.with(this).load("http://openweathermap.org/img/w/" + weather.icon + ".png").crossFade().into(ivIcon);
    }
}