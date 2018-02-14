/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matteo
 */
@XmlRootElement(name="credentials")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableauLoginResponse {

    public TableauUser getUser() {
        return user;
    }

    public void setUser(TableauUser user) {
        this.user = user;
    }

    public TableauSite getSite() {
        return site;
    }

    public void setSite(TableauSite site) {
        this.site = site;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private TableauUser user;
    private TableauSite site;
    private String token;

}
