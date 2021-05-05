package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.model.IModelObserver;
import com.mycompany.climaregist.model.WeatherData;
import java.util.List;

/**
 *
 * @author Davidson
 */
public class ultimaAtualizacaoObserver implements IModelObserver {

    private String data;
    private float temperatura;
    private float umidade;
    private float pressao;

    @Override
    public void update(List<WeatherData> dado) {

        if (dado.size() > 0) {
            data = dado.get(dado.size() - 1).getData();
            temperatura = dado.get(dado.size() - 1).getTemperatura();
            umidade = dado.get(dado.size() - 1).getUmidade();
            pressao = dado.get(dado.size() - 1).getPressao();

            PrincipalPresenter.atualizarUltima(data, temperatura, umidade, pressao);
        } else {
            PrincipalPresenter.atualizarUltima("-", 0, 0, 0);
        }

    }

}
