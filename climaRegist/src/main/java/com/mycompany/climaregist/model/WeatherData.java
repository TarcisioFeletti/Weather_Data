package com.mycompany.climaregist.model;

import com.mycompany.climaregist.collection.WeatherDataCollection;
import java.time.LocalDate;

/**
 *
 * @author Davidson
 */
public class WeatherData{

    private LocalDate data;
    private float temperatura;
    private float umidade;
    private float pressao;  

    public WeatherData(LocalDate data, float temperatura, float umidade, float pressao) {
        this.data = data;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
    }
    
    public LocalDate getData() {
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
   
    
}
