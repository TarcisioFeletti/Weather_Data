/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Adapter;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tarci
 */
public class ImpressoraJson {
    public void imprimir(String impressao) throws IOException{
        FileWriter fileWriter = new FileWriter("outputjson.json", true);
        fileWriter.write(impressao);
        fileWriter.close();
    }
}
