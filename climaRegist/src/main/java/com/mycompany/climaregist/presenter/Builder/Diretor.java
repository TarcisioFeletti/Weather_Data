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
public class Diretor {
    public Grafico constroi(GraficoBuilder builder){
        builder.criarGrafico();
        return builder.getGrafico();
    }
}
