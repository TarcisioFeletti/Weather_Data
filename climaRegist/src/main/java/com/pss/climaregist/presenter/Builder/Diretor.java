/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Builder;

import com.pss.climaregist.model.Grafico;

/**
 *
 * @author tarci
 */
public class Diretor {
    public Grafico constroi(GraficoBuilder builder){
        builder.criarGrafico();
        return (Grafico) builder.getGrafico();
    }
}
