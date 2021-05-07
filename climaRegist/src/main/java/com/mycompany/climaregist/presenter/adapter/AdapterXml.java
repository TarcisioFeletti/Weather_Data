/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Adapter;

import java.io.IOException;

/**
 *
 * @author tarci
 */
public class AdapterXml extends Adapter{
    private ImpressoraXml impressora;
    
    public AdapterXml(){
        impressora = new ImpressoraXml();
    }

    @Override
    public void adaptar(String data, String temperatura, String umidade, String pressao, String operacao) throws IOException {
        String logXml = "<log><Data>"+data+"</Data><Temperatura>"+temperatura+"</Temperatura><Umidade>"+umidade+
                "</Umidade><Pressao>"+pressao+"</Pressao><Operacao>"+operacao+"</Operacao></log>";
        impressora.imprimir(logXml);
    }
    
}
