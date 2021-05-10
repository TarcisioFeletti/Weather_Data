/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.climaregist.model;

import com.pss.climaregist.presenter.PrincipalPresenter;
import java.io.IOException;

/**
 *
 * @author tarci
 */
public interface IPrincipalPresenterCommand {
    public void executar(PrincipalPresenter presenter) throws IOException;
}
