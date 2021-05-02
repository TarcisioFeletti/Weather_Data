package com.mycompany.climaregist.model;
import com.mycompany.climaregist.view.TelaPrincipal;
/**
 *
 * @author Davidson
 */
public interface IRecebeDados {
        public void notificar ();
        public void registrar (IModelObserver ob);
        
}
