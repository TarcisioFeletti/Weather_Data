package com.mycompany.climaregist.model;

import com.mycompany.climaregist.presenter.atualizarTela;
import java.util.ArrayList;

/**
 *
 * @author Davidson
 */
public class ultimaAtualizacaoObserver implements IModelObserver {

    private String data;
    private float temperatura;
    private float umidade;
    private float pressao;

    public void update(ArrayList<dado> dado) {

        if (dado.size() > 0) {
            data = dado.get(dado.size() - 1).getData();
            temperatura = dado.get(dado.size() - 1).getTemperatura();
            umidade = dado.get(dado.size() - 1).getUmidade();
            pressao = dado.get(dado.size() - 1).getPressao();

            atualizarTela.atualizarUltima(data, temperatura, umidade, pressao);
        } else {
            atualizarTela.atualizarUltima("-", 0, 0, 0);
        }

    }

}
