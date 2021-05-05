/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Command;

import com.mycompany.climaregist.collection.WeatherDataCollection;
import com.mycompany.climaregist.model.banco;
import com.mycompany.climaregist.model.WeatherData;
import javax.swing.table.DefaultTableModel;
import org.json.XML;
import javax.swing.JTable;

/**
 *
 * @author Davidson
 */
import java.util.Vector;
import com.mycompany.climaregist.model.IPrincipalPresenterCommand;
import com.mycompany.climaregist.presenter.PrincipalPresenter;
import java.time.LocalDate;

public class PrincipalPresenterExcluirCommand implements IPrincipalPresenterCommand{

    @Override
    public void executar(PrincipalPresenter presenter) {
        JTable tabela = presenter.getTela().getRegistroTabela();

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        var row = tabela.getSelectedRow();

        org.json.JSONObject jsonObject = new org.json.JSONObject();

        jsonObject.put("Data", presenter.getTela().getRegistroTabela().getValueAt(row, 0));
        jsonObject.put("Temperatura", presenter.getTela().getRegistroTabela().getValueAt(row, 1));
        jsonObject.put("Umidade", presenter.getTela().getRegistroTabela().getValueAt(row, 2));
        jsonObject.put("Pressão", presenter.getTela().getRegistroTabela().getValueAt(row, 3));
        jsonObject.put("Tipo", "Remoção");
        String xml = XML.toString(jsonObject);
        banco.getXMLArray().append("<log>").append(xml).append("</log>");
        banco.getJsonArray().add(jsonObject);
        Vector vetor = model.getDataVector().elementAt(tabela.getSelectedRow());
        LocalDate data = LocalDate.of(Integer.parseInt(vetor.get(0).toString().substring(6, 10)), 
                Integer.parseInt(vetor.get(0).toString().substring(3, 5)),
                Integer.parseInt(vetor.get(0).toString().substring(0, 2)));
        WeatherDataCollection.getInstancia().remove(new WeatherData(data, Float.parseFloat(vetor.get(1).toString()),
                Float.parseFloat(vetor.get(2).toString()), Float.parseFloat(vetor.get(3).toString())));

    }

}
