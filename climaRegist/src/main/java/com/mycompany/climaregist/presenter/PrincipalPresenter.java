package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.presenter.Command.PrincipalPresenterIncluirCommand;
import com.mycompany.climaregist.model.IModelObserver;
import com.mycompany.climaregist.model.WeatherData;
import com.mycompany.climaregist.presenter.Command.PrincipalPresenterExcluirCommand;
import com.mycompany.climaregist.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davidson
 */
public class PrincipalPresenter implements IModelObserver {

    private static PrincipalPresenter instancia;
    private TelaPrincipalView tela;
    private int numRowsAnterior;

    private PrincipalPresenter() {
        tela = new TelaPrincipalView();
    }

    public static PrincipalPresenter getInstancia() {
        if (instancia == null) {
            instancia = new PrincipalPresenter();
        }
        return instancia;
    }

    public void iniciarListeners() {
        tela.getIncluirDados().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrincipalPresenterIncluirCommand().executar(instancia);
            }
        });

        tela.getRemoverBotao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrincipalPresenterExcluirCommand().executar(instancia);
            }
        });

    }

    public void atualizarUltima(String data, float temperatura, float umidade, float pressao) {
        tela.getUltimaData().setText(data);
        tela.getUltimaTemperatura().setText(Float.toString(temperatura));
        tela.getUltimaUmidade().setText(Float.toString(umidade));
        tela.getUltimaPressao().setText(Float.toString(pressao));
    }

    public void incluirNaTabela(WeatherData dado) {
        JTable registroTabela = tela.getRegistroTabela();
        DefaultTableModel model = (DefaultTableModel) registroTabela.getModel();

        model.addRow(new Object[]{dado.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            dado.getTemperatura(), dado.getUmidade(), dado.getPressao()});
    }

    public void excluirDaTabela() {
        JTable registroTabela = tela.getRegistroTabela();
        DefaultTableModel model = (DefaultTableModel) registroTabela.getModel();

        model.removeRow(registroTabela.getSelectedRow());
    }

    public void atualizarMedia(float temperatura, float umidade, float pressao, int count) {
        tela.getMedioTemperatura().setText(Float.toString(temperatura));
        tela.getMedioUmidade().setText(Float.toString(umidade));
        tela.getMedioPressao().setText(Float.toString(pressao));
        tela.getMedioRegistros().setText(Integer.toString(count));
    }

    public TelaPrincipalView getTela() {
        return tela;
    }

    @Override
    public void update(List<WeatherData> weatherDataCollection) {
        if (weatherDataCollection.size() > 0) {
            WeatherData weatherData = weatherDataCollection.get(weatherDataCollection.size() - 1);
            atualizarUltima(weatherData.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), weatherData.getTemperatura(),
                    weatherData.getUmidade(), weatherData.getPressao());
            switch (tela.getSelecionadoPeriodo().getSelectedIndex()) {
                case 0:
                    atualizarMedia(CalcularMediaDiariaPresenter.getInstancia().getMediaTemperatura(),
                            CalcularMediaDiariaPresenter.getInstancia().getMediaUmidade(),
                            CalcularMediaDiariaPresenter.getInstancia().getMediaPressao(),
                            CalcularMediaDiariaPresenter.getInstancia().getCount());
                    break;
                case 1:
                    atualizarMedia(CalcularMediaSemanalPresenter.getInstancia().getMediaTemperatura(),
                            CalcularMediaSemanalPresenter.getInstancia().getMediaUmidade(),
                            CalcularMediaSemanalPresenter.getInstancia().getMediaPressao(),
                            CalcularMediaSemanalPresenter.getInstancia().getCount());
                    break;
                case 2:
                    atualizarMedia(CalcularMediaMensalPresenter.getInstancia().getMediaTemperatura(),
                            CalcularMediaMensalPresenter.getInstancia().getMediaUmidade(),
                            CalcularMediaMensalPresenter.getInstancia().getMediaPressao(),
                            CalcularMediaMensalPresenter.getInstancia().getCount());
                    break;
            }
            if (numRowsAnterior < weatherDataCollection.size()) {
                incluirNaTabela(weatherDataCollection.get(weatherDataCollection.size() - 1));
            } else {
                excluirDaTabela();
            }
        }else{
            atualizarUltima("", 0, 0, 0);
            atualizarMedia(0, 0, 0, 0);
            excluirDaTabela();
        }

    }
}
