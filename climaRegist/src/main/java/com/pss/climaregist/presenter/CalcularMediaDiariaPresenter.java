package com.pss.climaregist.presenter;

import com.pss.climaregist.model.IModelObserver;
import com.pss.climaregist.model.WeatherData;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Davidson
 */
public class CalcularMediaDiariaPresenter implements IModelObserver {

    private static CalcularMediaDiariaPresenter instancia;

    private int count;
    private float mediaTemperatura;
    private float mediaUmidade;
    private float mediaPressao;

    private CalcularMediaDiariaPresenter() {
    }

    public static CalcularMediaDiariaPresenter getInstancia() {
        if (instancia == null) {
            instancia = new CalcularMediaDiariaPresenter();
        }
        return instancia;
    }

    public int getCount() {
        return count;
    }

    public float getMediaTemperatura() {
        return mediaTemperatura;
    }

    public float getMediaUmidade() {
        return mediaUmidade;
    }

    public float getMediaPressao() {
        return mediaPressao;
    }

    @Override
    public void update(List<WeatherData> weatherDataCollection) {
        try {

            mediaTemperatura = 0;
            mediaUmidade = 0;
            mediaPressao = 0;
            count = 0;
            var today = LocalDate.now();

            for (WeatherData weatherData : weatherDataCollection) {
                if (today.equals(weatherData.getData())) {
                    mediaTemperatura += weatherData.getTemperatura();
                    mediaUmidade += weatherData.getUmidade();
                    mediaPressao += weatherData.getPressao();
                    count++;
                }
            }
            mediaTemperatura = mediaTemperatura / count;
            mediaUmidade = mediaUmidade / count;
            mediaPressao = mediaPressao / count;
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
    }
}
