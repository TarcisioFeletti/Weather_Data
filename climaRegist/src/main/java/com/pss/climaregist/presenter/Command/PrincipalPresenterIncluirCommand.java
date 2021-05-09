package com.pss.climaregist.presenter.Command;

import com.pss.climaregist.collection.WeatherDataCollection;
import com.pss.climaregist.model.IPrincipalPresenterCommand;
import com.pss.climaregist.model.WeatherData;
import com.pss.climaregist.presenter.PrincipalPresenter;
import java.time.LocalDate;

/**
 *
 * @author Davidson
 */
public class PrincipalPresenterIncluirCommand implements IPrincipalPresenterCommand {

    @Override
    public void executar(PrincipalPresenter presenter) {
        LocalDate data = LocalDate.of(Integer.parseInt(presenter.getTela().getDadosTempoData().getText().substring(6, 10)),
                Integer.parseInt(presenter.getTela().getDadosTempoData().getText().substring(3, 5)),
                Integer.parseInt(presenter.getTela().getDadosTempoData().getText().substring(0, 2)));
        WeatherDataCollection.getInstancia().add(new WeatherData(data, Float.parseFloat(presenter.getTela().getDadosTempoTemperatura().getText()),
                Float.parseFloat(presenter.getTela().getDadosTempoUmidade().getText()),
                Float.parseFloat(presenter.getTela().getDadosTempoPressao().getText())));

        presenter.getTela().getDadosTempoData().setText("");
        presenter.getTela().getDadosTempoUmidade().setText("");
        presenter.getTela().getDadosTempoPressao().setText("");
        presenter.getTela().getDadosTempoTemperatura().setText("");
    }
}
