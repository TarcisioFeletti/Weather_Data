package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.model.IModelObserver;
import com.mycompany.climaregist.model.WeatherData;
import java.util.List;

/**
 *
 * @author Davidson
 */
public class atualizarTabelModeloObserver implements IModelObserver {
    
    private  static int anterior;
    private int atual;
       
    public atualizarTabelModeloObserver(){
        anterior = 0;
    }
    
    @Override
    public void update(List<WeatherData> weatherData) {
        atual = weatherData.size();
        if (anterior < atual && weatherData.size() > 0){
            PrincipalPresenter.atualizarTabela(weatherData.get(weatherData.size()-1));
            anterior = atual;
        }
      
    }
}
