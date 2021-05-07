/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Builder;

import com.mycompany.climaregist.model.Grafico;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author tarci
 */
public abstract class GraficoBuilder {
    private Grafico grafico;

    public GraficoBuilder(Grafico grafico) {
        this.grafico = grafico;
    }
    
    public Grafico getGrafico() {
        return grafico;
    }
    
    public abstract void criarGrafico();
}
