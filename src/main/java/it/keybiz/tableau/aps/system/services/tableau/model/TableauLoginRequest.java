/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.keybiz.tableau.aps.system.services.tableau.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matteo
 */
@XmlRootElement(name="credentials")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableauLoginRequest {

    public TableauLoginRequest() { }

    public TableauLoginRequest(String username, String password, String site) {
        this.username = username;
        this.password = password;
        this.site = new TableauSite(site);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TableauSite getSite() {
        return site;
    }

    public void setSite(TableauSite site) {
        this.site = site;
    }

    @XmlElement(name = "name")
    private String username;
    private String password;
    private TableauSite site;

}
