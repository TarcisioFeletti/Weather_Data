/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Decorator;

import java.awt.Color;

/**
 *
 * @author Lucas Carvalho
 */
public class CorDeFundoDecorator extends GraficoDecorator {

    public CorDeFundoDecorator(IGrafico componente) {
        super(componente);
        //decoração
        componente.getGraficoTemperatura().getChart().setBackgroundPaint(Color.BLUE);
        componente.getGraficoPressao().getChart().setBackgroundPaint(Color.BLUE);
        componente.getGraficoUmidade().getChart().setBackgroundPaint(Color.BLUE);
    }

}
