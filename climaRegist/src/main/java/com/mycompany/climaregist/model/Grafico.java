/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.model;

import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author tarci
 */
public abstract class Grafico {
    private ChartPanel graficoTemperatura;
    private ChartPanel graficoUmidade;
    private ChartPanel graficoPressao;

    public ChartPanel getGraficoTemperatura() {
        return graficoTemperatura;
    }

    public void setGraficoTemperatura(ChartPanel graficoTemperatura) {
        this.graficoTemperatura = graficoTemperatura;
    }

    public ChartPanel getGraficoUmidade() {
        return graficoUmidade;
    }

    public void setGraficoUmidade(ChartPanel graficoUmidade) {
        this.graficoUmidade = graficoUmidade;
    }

    public ChartPanel getGraficoPressao() {
        return graficoPressao;
    }

    public void setGraficoPressao(ChartPanel graficoPressao) {
        this.graficoPressao = graficoPressao;
    }
    
    public abstract ChartPanel gerar();
    
    
}
