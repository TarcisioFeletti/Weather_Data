/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Decorator;

import com.mycompany.climaregist.model.Grafico;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tarci
 */
public abstract class DataSetDecorator extends Grafico{
    private DefaultCategoryDataset datasetTemperatura;
    private DefaultCategoryDataset datasetUmidade;
    private DefaultCategoryDataset datasetPressao;

    public DataSetDecorator(DefaultCategoryDataset datasetTemperatura, DefaultCategoryDataset datasetUmidade, DefaultCategoryDataset datasetPressao) {
        this.datasetTemperatura = datasetTemperatura;
        this.datasetUmidade = datasetUmidade;
        this.datasetPressao = datasetPressao;
    }
}
