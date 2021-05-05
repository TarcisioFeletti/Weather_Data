/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.model;

import com.mycompany.climaregist.presenter.PrincipalPresenter;

/**
 *
 * @author tarci
 */
public interface IPrincipalPresenterObserverCommand {
    public float executar(PrincipalPresenter presenter);
}
