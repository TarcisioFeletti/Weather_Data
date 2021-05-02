/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.model.banco;
import com.mycompany.climaregist.model.dado;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.XML;
import com.mycompany.climaregist.colection.dadoColection;
import com.mycompany.climaregist.principal;
import javax.swing.JTable;

/**
 *
 * @author Davidson
 */
import com.mycompany.climaregist.view.TelaPrincipal;
import java.util.Vector;

public class removerDados {

    public void removerDados() {
        dado dado = new dado();
        TelaPrincipal tela = principal.getTela();
        JTable tabela = tela.getRegistroTabela();

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        var row = tabela.getSelectedRow();

        org.json.JSONObject jsonObject = new org.json.JSONObject();

        jsonObject.put("Data", tela.getRegistroTabela().getValueAt(row, 0));
        jsonObject.put("Temperatura", tela.getRegistroTabela().getValueAt(row, 1));
        jsonObject.put("Umidade", tela.getRegistroTabela().getValueAt(row, 2));
        jsonObject.put("Pressão", tela.getRegistroTabela().getValueAt(row, 3));
        jsonObject.put("Tipo", "Remoção");
        String xml = XML.toString(jsonObject);
        banco.getXMLArray().append("<log>").append(xml).append("</log>");
        banco.getJsonArray().add(jsonObject);
        Vector vetor = model.getDataVector().elementAt(row);

        String data;
        String temperatura, umidade, pressao;

        data = vetor.get(0).toString();
        temperatura = vetor.get(1).toString();
        umidade = vetor.get(2).toString();
        pressao = vetor.get(3).toString();
        
        String[] vetorRemove = new String[4];
        vetorRemove[0] = data;
        vetorRemove[1] = temperatura;
        vetorRemove[2] = umidade;
        vetorRemove[3] = pressao;        
        
        model.removeRow(row);
        dado.removeInformacoes(vetorRemove);

    }

    public void update(dado dado) {
        atualizarTela.atualizarTabela(dado);

    }

}
