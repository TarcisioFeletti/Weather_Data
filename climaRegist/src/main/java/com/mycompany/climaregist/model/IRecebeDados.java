package com.mycompany.climaregist.model;
import com.mycompany.climaregist.view.TelaPrincipalView;
/**
 *
 * @author Davidson
 */
public interface IRecebeDados {
        public void notificar ();
        public void registrar (IModelObserver ob);
        
}
