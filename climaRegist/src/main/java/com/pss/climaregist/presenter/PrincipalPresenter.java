package com.pss.climaregist.presenter;

import com.pss.climaregist.model.IModelObserver;
import com.pss.climaregist.model.WeatherData;
import com.pss.climaregist.presenter.Command.PrincipalPresenterExcluirCommand;
import com.pss.climaregist.presenter.Command.PrincipalPresenterIncluirCommand;
import com.pss.climaregist.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davidson
 */
public class PrincipalPresenter implements IModelObserver {

    private static PrincipalPresenter instancia;
    private TelaPrincipalView tela;

    private PrincipalPresenter() {
        tela = new TelaPrincipalView();
        tela.setVisible(true);
        tela.setLocationRelativeTo(tela.getParent());
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
                try {
                    new PrincipalPresenterIncluirCommand().executar(instancia);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(tela, ex.getMessage());
                }
            }
        });

        tela.getRemoverBotao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PrincipalPresenterExcluirCommand().executar(instancia);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(tela, ex.getMessage());
                }
            }
        });

        tela.getSelecionadoPeriodo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tela.getSelecionadoPeriodo().getSelectedIndex()) {
                    case 0:
                        tela.getMedioTemperatura().setText(String.valueOf(CalcularMediaDiariaPresenter.getInstancia().getMediaTemperatura()));
                        tela.getMedioUmidade().setText(String.valueOf(CalcularMediaDiariaPresenter.getInstancia().getMediaUmidade()));
                        tela.getMedioPressao().setText(String.valueOf(CalcularMediaDiariaPresenter.getInstancia().getMediaPressao()));
                        tela.getMedioRegistros().setText(String.valueOf(CalcularMediaDiariaPresenter.getInstancia().getCount()));

                        break;
                    case 1:
                        tela.getMedioTemperatura().setText(String.valueOf(CalcularMediaSemanalPresenter.getInstancia().getMediaTemperatura()));
                        tela.getMedioUmidade().setText(String.valueOf(CalcularMediaSemanalPresenter.getInstancia().getMediaUmidade()));
                        tela.getMedioPressao().setText(String.valueOf(CalcularMediaSemanalPresenter.getInstancia().getMediaPressao()));
                        tela.getMedioRegistros().setText(String.valueOf(CalcularMediaSemanalPresenter.getInstancia().getCount()));
                        break;
                    case 2:
                        tela.getMedioTemperatura().setText(String.valueOf(CalcularMediaMensalPresenter.getInstancia().getMediaTemperatura()));
                        tela.getMedioUmidade().setText(String.valueOf(CalcularMediaMensalPresenter.getInstancia().getMediaUmidade()));
                        tela.getMedioPressao().setText(String.valueOf(CalcularMediaMensalPresenter.getInstancia().getMediaPressao()));
                        tela.getMedioRegistros().setText(String.valueOf(CalcularMediaMensalPresenter.getInstancia().getCount()));
                        break;
                }
            }
        });

        tela.getBtnGerarGrafico().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GraficoModalPresenter(PrincipalPresenter.getInstancia());
            }
        });

    }

    public void atualizarUltima(String data, float temperatura, float umidade, float pressao) {
        tela.getUltimaData().setText(data);
        tela.getUltimaTemperatura().setText(Float.toString(temperatura));
        tela.getUltimaUmidade().setText(Float.toString(umidade));
        tela.getUltimaPressao().setText(Float.toString(pressao));
    }

    public void atualizarTabela(List<WeatherData> weatherDataCollection) {
        JTable registroTabela = tela.getRegistroTabela();
        DefaultTableModel model = (DefaultTableModel) registroTabela.getModel();
        model.setNumRows(0);

        for (WeatherData weatherData : weatherDataCollection) {
            model.addRow(new Object[]{weatherData.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                weatherData.getTemperatura(), weatherData.getUmidade(), weatherData.getPressao()});
        }
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
            tela.getTotalDeRegistros().setText(String.valueOf(weatherDataCollection.size()));
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
            atualizarTabela(weatherDataCollection);
        } else {
            atualizarUltima("", 0, 0, 0);
            atualizarMedia(0, 0, 0, 0);
            tela.getTotalDeRegistros().setText("0");
            atualizarTabela(weatherDataCollection);
        }

    }
}
