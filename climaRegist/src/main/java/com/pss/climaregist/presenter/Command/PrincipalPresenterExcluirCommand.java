/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.presenter.Command;

import com.pss.climaregist.collection.WeatherDataCollection;
import com.pss.climaregist.model.IPrincipalPresenterCommand;
import com.pss.climaregist.model.WeatherData;
import com.pss.climaregist.presenter.PrincipalPresenter;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrincipalPresenterExcluirCommand implements IPrincipalPresenterCommand{

    @Override
    public void executar(PrincipalPresenter presenter) {
        JTable tabela = presenter.getTela().getRegistroTabela();

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        var row = tabela.getSelectedRow();

        Vector vetor = model.getDataVector().elementAt(tabela.getSelectedRow());
        LocalDate data = LocalDate.of(Integer.parseInt(vetor.get(0).toString().substring(6, 10)), 
                Integer.parseInt(vetor.get(0).toString().substring(3, 5)),
                Integer.parseInt(vetor.get(0).toString().substring(0, 2)));
        WeatherDataCollection.getInstancia().remove(new WeatherData(data, Float.parseFloat(vetor.get(1).toString()),
                Float.parseFloat(vetor.get(2).toString()), Float.parseFloat(vetor.get(3).toString())));

    }

}
