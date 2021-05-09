/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter;

import com.pss.climaregist.model.Grafico;
import com.pss.climaregist.presenter.Builder.Diretor;
import com.pss.climaregist.presenter.Builder.GraficoHorizontalBuilder;
import com.pss.climaregist.presenter.Builder.GraficoVerticalBuilder;
import com.pss.climaregist.presenter.Decorator.CorDeFundoDecorator;
import com.pss.climaregist.presenter.Decorator.CorDoTituloDecorator;
import com.pss.climaregist.presenter.Decorator.IGrafico;
import com.pss.climaregist.view.graficos.GraficosView;
import java.awt.BorderLayout;

/**
 *
 * @author Lucas Carvalho
 */
public class GraficoModalPresenter {

    private GraficosView view;

    public GraficoModalPresenter(PrincipalPresenter presenter) {
        Diretor diretor = new Diretor();
        IGrafico grafico = new Grafico();
        if (presenter.getTela().getEscolhaGrafico().getSelectedIndex() == 0) {
            grafico = diretor.constroi(new GraficoHorizontalBuilder(grafico));
        } else if (presenter.getTela().getEscolhaGrafico().getSelectedIndex() == 1) {
            grafico = diretor.constroi(new GraficoVerticalBuilder(grafico));
        }

        if (presenter.getTela().getCorFundo().isSelected()) {//cor de fundo azul
            grafico = new CorDeFundoDecorator(grafico);
        }
        if (presenter.getTela().getCorTitulo().isSelected()) {//cor do titulo rosa
            grafico = new CorDoTituloDecorator(grafico);
        }
        iniciarDialog(grafico, presenter);

    }

    public void iniciarDialog(IGrafico grafico, PrincipalPresenter presenter) {
        GraficosView graficosView = new GraficosView(presenter.getTela());
        graficosView.setLocationRelativeTo(graficosView.getParent());
        graficosView.getPanelGraficoTemperatura().setLayout(new BorderLayout());
        graficosView.getPanelGraficoUmidade().setLayout(new BorderLayout());
        graficosView.getPanelGraficoPressao().setLayout(new BorderLayout());
        graficosView.getPanelGraficoTemperatura().add(grafico.getGraficoTemperatura());
        graficosView.getPanelGraficoUmidade().add(grafico.getGraficoUmidade());
        graficosView.getPanelGraficoPressao().add(grafico.getGraficoPressao());
        graficosView.getPanelGraficoTemperatura().revalidate();
        graficosView.getPanelGraficoUmidade().revalidate();
        graficosView.getPanelGraficoPressao().revalidate();
        graficosView.setVisible(true);
    }
}
