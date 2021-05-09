/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Decorator;

import com.mycompany.climaregist.model.Grafico;
import com.mycompany.climaregist.presenter.Builder.Diretor;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author tarci
 */
public class GraficoHorizontalDecorator extends GraficoDecorator{

    public GraficoHorizontalDecorator(Grafico grafico) {
        super(grafico);
    }

    @Override
    public ChartPanel gerar() {
        Diretor diretor = new Diretor();
        return null;
    }
    
}
