package com.mycompany.climaregist.presenter;

import com.mycompany.climaregist.model.Grafico;
import com.mycompany.climaregist.presenter.Command.PrincipalPresenterIncluirCommand;
import com.mycompany.climaregist.model.IModelObserver;
import com.mycompany.climaregist.model.WeatherData;
import com.mycompany.climaregist.presenter.Adapter.AdapterJson;
import com.mycompany.climaregist.presenter.Adapter.AdapterXml;
import com.mycompany.climaregist.presenter.Builder.Diretor;
import com.mycompany.climaregist.presenter.Builder.GraficoHorizontalBuilder;
import com.mycompany.climaregist.presenter.Builder.GraficoVerticalBuilder;
import com.mycompany.climaregist.presenter.Command.PrincipalPresenterExcluirCommand;
import com.mycompany.climaregist.view.TelaPrincipalView;
import com.mycompany.climaregist.view.graficos.GraficosView;
import java.awt.BorderLayout;
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

                Diretor diretor = new Diretor();
                //Grafico grafico = new Grafico();
                if (tela.getEscolhaGrafico().getSelectedIndex() == 0) {
                    //grafico = diretor.constroi(new GraficoHorizontalBuilder(grafico));
                } else if (tela.getEscolhaGrafico().getSelectedIndex() == 1) {
                    //grafico = diretor.constroi(new GraficoVerticalBuilder(grafico));
                }
                //iniciarDialog(grafico);
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

    public void iniciarDialog(Grafico grafico) {
        GraficosView graficosView = new GraficosView(tela);
        graficosView.setLocationRelativeTo(graficosView.getParent());
        graficosView.getPanelGraficoTemperatura().setLayout(new BorderLayout());
        graficosView.getPanelGraficoUmidade().setLayout(new BorderLayout());
        graficosView.getPanelGraficoPressao().setLayout(new BorderLayout());
        graficosView.getPanelGraficoTemperatura().add(grafico.getGraficoTemperatura());
        graficosView.getPanelGraficoUmidade().add(grafico.getGraficoUmidade());
        graficosView.getPanelGraficoPressao().add(grafico.getGraficoPressao());
        graficosView.getPanelGraficoTemperatura().revalidate();
        graficosView.getPanelGraficoUmidade().revalidate();
        graficosView.getPanelGraficoPressao().revalidate();
        graficosView.setVisible(true);
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
                numRowsAnterior = weatherDataCollection.size();
                try {
                    new AdapterJson().adaptar(weatherData.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), String.valueOf(weatherData.getTemperatura()), String.valueOf(weatherData.getUmidade()), String.valueOf(weatherData.getPressao()), "inclusao");
                    new AdapterXml().adaptar(weatherData.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), String.valueOf(weatherData.getTemperatura()), String.valueOf(weatherData.getUmidade()), String.valueOf(weatherData.getPressao()), "inclusao");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(tela, ex.getMessage());
                }
            } else {
                excluirDaTabela();
                numRowsAnterior = weatherDataCollection.size();
                try {
                    new AdapterJson().adaptar(weatherData.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), String.valueOf(weatherData.getTemperatura()), String.valueOf(weatherData.getUmidade()), String.valueOf(weatherData.getPressao()), "exclusao");
                    new AdapterXml().adaptar(weatherData.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), String.valueOf(weatherData.getTemperatura()), String.valueOf(weatherData.getUmidade()), String.valueOf(weatherData.getPressao()), "exclusao");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(tela, ex.getMessage());
                }
            }

        } else {
            atualizarUltima("", 0, 0, 0);
            atualizarMedia(0, 0, 0, 0);
            WeatherData weatherData = weatherDataCollection.get(0);
            excluirDaTabela();
            try {
                new AdapterJson().adaptar(weatherData.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), String.valueOf(weatherData.getTemperatura()), String.valueOf(weatherData.getUmidade()), String.valueOf(weatherData.getPressao()), "exclusao");
                new AdapterXml().adaptar(weatherData.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), String.valueOf(weatherData.getTemperatura()), String.valueOf(weatherData.getUmidade()), String.valueOf(weatherData.getPressao()), "exclusao");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(tela, ex.getMessage());
            }
        }

    }
}
