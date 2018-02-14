/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau;

import org.entando.entando.plugins.jptableau.aps.system.services.tableau.model.TableauLoginRequest;

/**
 *
 * @author matteo
 */
public class TableauConfig {

    public String getApiVer() {
        return apiVer;
    }

    public void setApiVer(String apiVer) {
        this.apiVer = apiVer;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public TableauLoginRequest getLogin() {
        return login;
    }

    public void setLogin(TableauLoginRequest login) {
        this.login = login;
    }

    private String apiVer;
    private String baseAddress;
    private TableauLoginRequest login;

}
