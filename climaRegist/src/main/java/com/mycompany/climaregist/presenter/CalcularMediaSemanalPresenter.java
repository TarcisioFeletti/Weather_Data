/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.model.IModelObserver;
import com.mycompany.climaregist.model.WeatherData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author tarci
 */
public class CalcularMediaSemanalPresenter implements IModelObserver {

    private static CalcularMediaSemanalPresenter instancia;

    private int count;
    private float mediaTemperatura;
    private float mediaUmidade;
    private float mediaPressao;

    private CalcularMediaSemanalPresenter() {
    }

    public static CalcularMediaSemanalPresenter getInstancia() {
        if (instancia == null) {
            instancia = new CalcularMediaSemanalPresenter();
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
                if (weatherData.getData().compareTo(today.minusWeeks(1)) > 0 && today.until(weatherData.getData(), ChronoUnit.DAYS) < 7) {
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
