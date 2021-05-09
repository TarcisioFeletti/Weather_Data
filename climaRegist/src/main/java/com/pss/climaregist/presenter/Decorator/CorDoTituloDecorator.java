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
public class CorDoTituloDecorator extends GraficoDecorator {

    public CorDoTituloDecorator(IGrafico componente) {
        super(componente);
        //decoração
        componente.getGraficoTemperatura().getChart().getTitle().setPaint(Color.PINK);
        componente.getGraficoPressao().getChart().getTitle().setPaint(Color.PINK);
        componente.getGraficoUmidade().getChart().getTitle().setPaint(Color.PINK);
    }
}
