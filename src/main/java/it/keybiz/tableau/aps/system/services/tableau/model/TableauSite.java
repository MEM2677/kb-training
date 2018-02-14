/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.keybiz.tableau.aps.system.services.tableau.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matteo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TableauSite {

    public TableauSite() { }

    public TableauSite(String site) {
        this.contentUrl = site;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String contentUrl;
    private String id;

}
