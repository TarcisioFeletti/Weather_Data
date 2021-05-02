package com.mycompany.climaregist.model;

import com.mycompany.climaregist.colection.dadoColection;

/**
 *
 * @author Davidson
 */
public class dado{

    private String data;
    private float temperatura;
    private float umidade;
    private float pressao;   
    
    public String getData() {
        return data;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public float getPressao() {
        return pressao;
    }
    
    public void setInformacoes(String[] dados){
        data = dados[0];
        temperatura = (Float.parseFloat(dados[1]));
        umidade = (Float.parseFloat(dados[2]));
        pressao = (Float.parseFloat(dados[3]));
        dadoColection dadoscolect = dadoColection.getIntances();
        dadoscolect.add(this);
    }
    
    public void removeInformacoes(String[] dados){
        data = dados[0];
        temperatura = (Float.parseFloat(dados[1]));
        umidade = (Float.parseFloat(dados[2]));
        pressao = (Float.parseFloat(dados[3]));
        dadoColection dadoscolect = dadoColection.getIntances();
        dadoscolect.remove(this);
    }
   
    
}
