/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.adapter;

import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author tarci
 */
public class AdapterJson extends Adapter{
    private ImpressoraJson impressora;
    private JSONObject jsonObject;
    
    public AdapterJson(){
        impressora = new ImpressoraJson();
        jsonObject = new JSONObject();
    }

    @Override
    public void adaptar(String data, String temperatura, String umidade, String pressao, String operacao) throws IOException {
        jsonObject.put("Data", data);
        jsonObject.put("Temperatura", temperatura);
        jsonObject.put("Umidade", umidade);
        jsonObject.put("Pressão", pressao);
        jsonObject.put("Tipo", operacao);
        impressora.imprimir(jsonObject.toString());
    }
}
