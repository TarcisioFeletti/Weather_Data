/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Decorator;

import com.mycompany.climaregist.model.Grafico;

/**
 *
 * @author tarci
 */
public abstract class GraficoDecorator extends Grafico{
    private Grafico grafico;
    
    public GraficoDecorator(Grafico grafico){
        this.grafico = grafico;
    }
    
}
