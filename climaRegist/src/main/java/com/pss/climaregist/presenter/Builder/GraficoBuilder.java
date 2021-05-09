/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Builder;

import com.pss.climaregist.presenter.Decorator.IGrafico;

/**
 *
 * @author tarci
 */
public abstract class GraficoBuilder {
    private IGrafico grafico;

    public GraficoBuilder(IGrafico grafico) {
        this.grafico = grafico;
    }
    
    public IGrafico getGrafico() {
        return grafico;
    }
    
    public abstract void criarGrafico();
}
