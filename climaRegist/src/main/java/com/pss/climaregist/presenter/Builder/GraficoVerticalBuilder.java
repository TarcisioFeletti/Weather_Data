/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Builder;

import com.pss.climaregist.collection.WeatherDataCollection;
import com.pss.climaregist.model.WeatherData;
import com.pss.climaregist.presenter.Decorator.IGrafico;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tarci
 */
public class GraficoVerticalBuilder extends GraficoBuilder {

    private List<WeatherData> weatherDataTempCollection;

    public GraficoVerticalBuilder(IGrafico grafico) {
        super(grafico);
        weatherDataTempCollection = new ArrayList<>();
    }

    @Override
    public void criarGrafico() {
        DefaultCategoryDataset barrasTemperatura = new DefaultCategoryDataset();
        DefaultCategoryDataset barrasUmidade = new DefaultCategoryDataset();
        DefaultCategoryDataset barrasPressao = new DefaultCategoryDataset();
        for (WeatherData weatherData : WeatherDataCollection.getInstancia().getWeatherDataCollection()) {
            weatherDataTempCollection.add(weatherData);
        }

        for (int i = 0; i < weatherDataTempCollection.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < weatherDataTempCollection.size(); j++) {
                if (weatherDataTempCollection.get(j).getData().equals(weatherDataTempCollection.get(i).getData())) {
                    weatherDataTempCollection.get(i).setTemperatura(weatherDataTempCollection.get(i).getTemperatura() + weatherDataTempCollection.get(j).getTemperatura());
                    weatherDataTempCollection.get(i).setUmidade(weatherDataTempCollection.get(i).getUmidade() + weatherDataTempCollection.get(j).getUmidade());
                    weatherDataTempCollection.get(i).setPressao(weatherDataTempCollection.get(i).getPressao() + weatherDataTempCollection.get(j).getPressao());
                    weatherDataTempCollection.remove(j);
                    count++;
                }
            }
            weatherDataTempCollection.get(i).setTemperatura(weatherDataTempCollection.get(i).getTemperatura() / count);
            weatherDataTempCollection.get(i).setUmidade(weatherDataTempCollection.get(i).getUmidade() / count);
            weatherDataTempCollection.get(i).setPressao(weatherDataTempCollection.get(i).getPressao() / count);
            barrasTemperatura.setValue(weatherDataTempCollection.get(i).getTemperatura(),
                    weatherDataTempCollection.get(i).getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "");
            barrasUmidade.setValue(weatherDataTempCollection.get(i).getUmidade(),
                    weatherDataTempCollection.get(i).getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "");
            barrasPressao.setValue(weatherDataTempCollection.get(i).getPressao(),
                    weatherDataTempCollection.get(i).getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "");
        }

        super.getGrafico().setGraficoTemperatura(new ChartPanel(ChartFactory.createBarChart("Temperatura", "Data", "", barrasTemperatura, PlotOrientation.VERTICAL, true, true, false)));
        super.getGrafico().setGraficoUmidade(new ChartPanel(ChartFactory.createBarChart("Umidade", "Data", "", barrasUmidade, PlotOrientation.VERTICAL, true, true, false)));
        super.getGrafico().setGraficoPressao(new ChartPanel(ChartFactory.createBarChart("Pressao", "Data", "", barrasPressao, PlotOrientation.VERTICAL, true, true, false)));
    }

}
