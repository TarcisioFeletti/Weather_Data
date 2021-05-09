/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Decorator;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author tarci
 */
public abstract class GraficoDecorator implements IGrafico {

    private IGrafico componente;

    public GraficoDecorator(IGrafico componente) {
        this.componente = componente;
    }

    @Override
    public ChartPanel getGraficoTemperatura() {
        return this.componente.getGraficoTemperatura();
    }

    @Override
    public void setGraficoTemperatura(ChartPanel graficoTemperatura) {
        this.componente.setGraficoTemperatura(graficoTemperatura);
    }

    @Override
    public ChartPanel getGraficoUmidade() {
        return this.componente.getGraficoUmidade();
    }

    @Override
    public void setGraficoUmidade(ChartPanel setGraficoUmidade) {
        this.componente.setGraficoUmidade(setGraficoUmidade);
    }

    @Override
    public ChartPanel getGraficoPressao() {
        return this.componente.getGraficoPressao();
    }

    @Override
    public void setGraficoPressao(ChartPanel graficoPressao) {
        this.componente.setGraficoPressao(graficoPressao);
    }
}
