package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.principal;
import com.mycompany.climaregist.model.banco;
import com.mycompany.climaregist.model.dado;
import com.mycompany.climaregist.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import org.json.XML;
import org.json.simple.JSONObject;

/**
 *
 * @author Davidson
 */
public class enviaDados {    
    
    
    public void enviar(TelaPrincipal tela){
        dado dado = new dado();
        String dados[] = new String[4];
        dados[0] = tela.getDadosTempoData().getText();
        dados[1] = tela.getDadosTempoTemperatura().getText();
        dados[2] = tela.getDadosTempoUmidade().getText();
        dados[3] = tela.getDadosTempoPressao().getText();
        dado.setInformacoes(dados);
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Data", tela.getDadosTempoData().getText());
        jsonObject.put("Temperatura", tela.getDadosTempoTemperatura().getText());
        jsonObject.put("Umidade", tela.getDadosTempoUmidade().getText());
        jsonObject.put("Pressão", tela.getDadosTempoPressao().getText());
        jsonObject.put("Tipo", "Inclusão");
        String xml = XML.toString(jsonObject);
        banco.getJsonArray().add(jsonObject);
        banco.getXMLArray().append("<log>").append(xml).append("</log>");
        
        tela.getDadosTempoData().setText("");
        tela.getDadosTempoUmidade().setText("");
        tela.getDadosTempoPressao().setText("");
        tela.getDadosTempoTemperatura().setText("");
    }
    
    public static int getIndex(){
        TelaPrincipal tela = principal.getTela();
        return tela.getSelecionadoPeriodo().getSelectedIndex();
    }
}
