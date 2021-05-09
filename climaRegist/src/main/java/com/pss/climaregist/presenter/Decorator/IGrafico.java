/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Decorator;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author Lucas Carvalho
 */
public interface IGrafico {

    public ChartPanel getGraficoTemperatura();

    public void setGraficoTemperatura(ChartPanel graficoTemperatura);

    public ChartPanel getGraficoUmidade();

    public void setGraficoUmidade(ChartPanel graficoUmidade);

    public ChartPanel getGraficoPressao();

    public void setGraficoPressao(ChartPanel graficoPressao);
}
