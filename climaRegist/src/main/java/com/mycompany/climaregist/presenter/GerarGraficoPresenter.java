/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.view.TelaPrincipalView;
import com.mycompany.climaregist.view.graficos.GraficosView;
import java.awt.Frame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Davidson
 */
public class GerarGraficoPresenter {

    private GraficosView viewGraficos;
    private TelaPrincipalView tela;

    public GerarGraficoPresenter(Frame parent, boolean modal) {
        viewGraficos = new GraficosView(parent, true);
    }

    public void viewGraficos(TelaPrincipalView tela) {
        viewGraficos.setVisible(true);
        criarGrafico();

    }

    public void criarGrafico() {
        if (tela.getEscolhaGrafico().getSelectedIndex() == 0) {
            DefaultCategoryDataset barra = new DefaultCategoryDataset();
            barra.setValue(1400, "Chine", "");
            barra.setValue(1200, "Brasil", "");
            barra.setValue(320, "EUA", "");
            barra.setValue(210, "Brasil", "");
            barra.setValue(115, "Portugal", "");

            JFreeChart grafico = ChartFactory.createBarChart3D("População mundial", "Países", "Milhões", barra, PlotOrientation.HORIZONTAL, true, true, true);
            
            ChartPanel painel = new ChartPanel(grafico);

        } else if (tela.getEscolhaGrafico().getSelectedIndex() == 1) {
            DefaultCategoryDataset barra = new DefaultCategoryDataset();
            barra.setValue(1400, "Chine", "");
            barra.setValue(1200, "Brasil", "");
            barra.setValue(320, "EUA", "");
            barra.setValue(210, "Brasil", "");
            barra.setValue(115, "Portugal", "");

            JFreeChart grafico = ChartFactory.createBarChart3D("População mundial", "Países", "Milhões", barra, PlotOrientation.VERTICAL, true, true, true);

            ChartPanel painel = new ChartPanel(grafico);

        }
        
    }
}
