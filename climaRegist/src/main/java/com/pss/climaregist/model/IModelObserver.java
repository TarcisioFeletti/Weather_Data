package com.pss.climaregist.model;

import java.util.List;

/**
 *
 * @author Davidson
 */
public interface IModelObserver {
    public void update (List <WeatherData>  dados);
    
}
