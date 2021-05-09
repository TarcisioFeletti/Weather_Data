/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter;

import com.pss.climaregist.collection.WeatherDataCollection;
import com.pss.climaregist.model.IModelObserver;
import com.pss.climaregist.model.WeatherData;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tarci
 */
public class CalcularMediaMensalPresenter implements IModelObserver {

    private static CalcularMediaMensalPresenter instancia;
    private int count;
    private float mediaTemperatura;
    private float mediaUmidade;
    private float mediaPressao;

    private CalcularMediaMensalPresenter() {
    }

    public static CalcularMediaMensalPresenter getInstancia() {
        if (instancia == null) {
            instancia = new CalcularMediaMensalPresenter();
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

            for (WeatherData weatherData : WeatherDataCollection.getInstancia().getWeatherDataCollection()) {
                if (today.getMonthValue() == weatherData.getData().getMonthValue()) {
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
