/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.model;

import com.pss.climaregist.presenter.Decorator.IGrafico;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author tarci
 */
public class Grafico implements IGrafico {
    private ChartPanel graficoTemperatura;
    private ChartPanel graficoUmidade;
    private ChartPanel graficoPressao;

    @Override
    public ChartPanel getGraficoTemperatura() {
        return graficoTemperatura;
    }

    @Override
    public void setGraficoTemperatura(ChartPanel graficoTemperatura) {
        this.graficoTemperatura = graficoTemperatura;
    }

    @Override
    public ChartPanel getGraficoUmidade() {
        return graficoUmidade;
    }

    @Override
    public void setGraficoUmidade(ChartPanel graficoUmidade) {
        this.graficoUmidade = graficoUmidade;
    }

    @Override
    public ChartPanel getGraficoPressao() {
        return graficoPressao;
    }

    @Override
    public void setGraficoPressao(ChartPanel graficoPressao) {
        this.graficoPressao = graficoPressao;
    }
        
}
