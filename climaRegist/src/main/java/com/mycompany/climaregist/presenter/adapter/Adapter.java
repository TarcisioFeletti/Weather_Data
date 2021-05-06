/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.adapter;

import java.io.IOException;

/**
 *
 * @author tarci
 */
public abstract class Adapter {
    public abstract void adaptar(String data, String temperatura, String umidade, String pressao, String operacao) throws IOException;
}
