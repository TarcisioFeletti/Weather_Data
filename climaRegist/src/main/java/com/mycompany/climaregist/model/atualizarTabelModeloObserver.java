package com.mycompany.climaregist.model;

import com.mycompany.climaregist.presenter.atualizarTela;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
    
    public void update(ArrayList<dado> dado) {
        atual = dado.size();
        if (anterior < atual && dado.size() > 0){
            atualizarTela.atualizarTabela(dado.get(dado.size()-1));
        }
      
    }
}
