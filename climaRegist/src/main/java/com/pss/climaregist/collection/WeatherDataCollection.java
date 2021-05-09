/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.collection;

import com.pss.climaregist.model.IModelObserver;
import com.pss.climaregist.model.IRecebeDados;
import com.pss.climaregist.model.WeatherData;
import com.pss.climaregist.presenter.CalcularMediaDiariaPresenter;
import com.pss.climaregist.presenter.CalcularMediaMensalPresenter;
import com.pss.climaregist.presenter.CalcularMediaSemanalPresenter;
import com.pss.climaregist.presenter.PrincipalPresenter;
import java.util.ArrayList;

/**
 *
 * @author Davidson
 */
public class WeatherDataCollection implements IRecebeDados {
    
    private ArrayList<IModelObserver> observerCollection;
    private ArrayList<WeatherData> weatherDataCollection;

    public ArrayList<WeatherData> getWeatherDataCollection() {
        return weatherDataCollection;
    }
     
    private static WeatherDataCollection instancia;
    
    private WeatherDataCollection (){
        observerCollection = new ArrayList<>();
        weatherDataCollection = new ArrayList<>();
        registrar(CalcularMediaDiariaPresenter.getInstancia());
        registrar(CalcularMediaSemanalPresenter.getInstancia());
        registrar(CalcularMediaMensalPresenter.getInstancia());
        registrar(PrincipalPresenter.getInstancia());
    }
    
    
    @Override
    public  void notificar (){
        for (int i = 0; i < observerCollection.size(); i++){
            IModelObserver ob = observerCollection.get(i);
            ob.update(weatherDataCollection);
        }
    }
    
    @Override
    public void registrar (IModelObserver ob){
        observerCollection.add(ob);
    }
    
    public void add (WeatherData weatherData){
        weatherDataCollection.add(weatherData);
        notificar();
    }
    
    public void remove (WeatherData dado){
        
        for (int i = 0; i < weatherDataCollection.size(); i++){
            if (weatherDataCollection.get(i).getData().equals(dado.getData())){
                weatherDataCollection.remove(i);
                notificar();
            }
        }
    }
    
    public static WeatherDataCollection getInstancia (){
        if (instancia == null){
            instancia = new WeatherDataCollection();
        }
        
        return instancia;
    }
}
