/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Builder;

import com.mycompany.climaregist.collection.WeatherDataCollection;
import com.mycompany.climaregist.model.Grafico;
import com.mycompany.climaregist.model.WeatherData;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tarci
 */
public class GraficoVerticalBuilder extends GraficoBuilder {

    public GraficoVerticalBuilder(Grafico grafico) {
        super(grafico);
    }

    @Override
    public void criarGrafico() {
        DefaultCategoryDataset barrasTemperatura = new DefaultCategoryDataset();
        DefaultCategoryDataset barrasUmidade = new DefaultCategoryDataset();
        DefaultCategoryDataset barrasPressao = new DefaultCategoryDataset();

        for (WeatherData weatherData : WeatherDataCollection.getInstancia().getWeatherDataCollection()) {
            barrasTemperatura.setValue(weatherData.getTemperatura(),
                    weatherData.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "");
            barrasUmidade.setValue(weatherData.getUmidade(),
                    weatherData.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "");
            barrasPressao.setValue(weatherData.getPressao(),
                    weatherData.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "");
        }
        super.getGrafico().setGraficoTemperatura(new ChartPanel(ChartFactory.createBarChart("Temperatura", "Data", "", barrasTemperatura, PlotOrientation.VERTICAL, true, true, false)));
        super.getGrafico().setGraficoUmidade(new ChartPanel(ChartFactory.createBarChart("Umidade", "Data", "", barrasUmidade, PlotOrientation.VERTICAL, true, true, false)));
        super.getGrafico().setGraficoPressao(new ChartPanel(ChartFactory.createBarChart("Pressao", "Data", "", barrasPressao, PlotOrientation.VERTICAL, true, true, false)));
    }

}
