package com.mycompany.climaregist;

import com.mycompany.climaregist.model.dado;
import com.mycompany.climaregist.presenter.enviaDados;
import com.mycompany.climaregist.presenter.removerDados;
import com.mycompany.climaregist.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Davidson
 */
public class principal {

    private static TelaPrincipal tela;

    public static TelaPrincipal getTela() {
        return tela;
    }

    public static void main(String args[]) {
        tela = new TelaPrincipal();
        enviaDados incluir = new enviaDados();
        removerDados remove = new removerDados();

        tela.getIncluirDados().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluir.enviar(tela);
            }
        });

        tela.getRemoverBotao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove.removerDados();
            }
        });

    }
}
