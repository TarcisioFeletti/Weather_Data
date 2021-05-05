package com.mycompany.climaregist.presenter.Command;

import com.mycompany.climaregist.model.banco;
import com.mycompany.climaregist.model.WeatherData;
import org.json.XML;
import org.json.simple.JSONObject;
import com.mycompany.climaregist.model.IPrincipalPresenterCommand;
import com.mycompany.climaregist.presenter.PrincipalPresenter;
import java.time.LocalDate;

/**
 *
 * @author Davidson
 */
public class PrincipalPresenterIncluirCommand implements IPrincipalPresenterCommand{    
    
    
    @Override
    public void executar(PrincipalPresenter presenter){
        LocalDate data = LocalDate.of(Integer.parseInt(presenter.getTela().getDadosTempoData().getText().substring(6, 10)), 
                Integer.parseInt(presenter.getTela().getDadosTempoData().getText().substring(3, 5)),
                Integer.parseInt(presenter.getTela().getDadosTempoData().getText().substring(0, 2)));
        WeatherData weatherData = new WeatherData(data, Float.parseFloat(presenter.getTela().getDadosTempoTemperatura().getText()),
                Float.parseFloat(presenter.getTela().getDadosTempoUmidade().getText()), 
                Float.parseFloat(presenter.getTela().getDadosTempoPressao().getText()));
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Data", presenter.getTela().getDadosTempoData().getText());
        jsonObject.put("Temperatura", presenter.getTela().getDadosTempoTemperatura().getText());
        jsonObject.put("Umidade", presenter.getTela().getDadosTempoUmidade().getText());
        jsonObject.put("Pressão", presenter.getTela().getDadosTempoPressao().getText());
        jsonObject.put("Tipo", "Inclusão");
        String xml = XML.toString(jsonObject);
        banco.getJsonArray().add(jsonObject);
        banco.getXMLArray().append("<log>").append(xml).append("</log>");
        
        presenter.getTela().getDadosTempoData().setText("");
        presenter.getTela().getDadosTempoUmidade().setText("");
        presenter.getTela().getDadosTempoPressao().setText("");
        presenter.getTela().getDadosTempoTemperatura().setText("");
    }
}
