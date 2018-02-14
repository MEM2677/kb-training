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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TableauUserListResponse {

    public TableauUserList getPayload() {
        return payload;
    }

    public void setPayload(TableauUserList payload) {
        this.payload = payload;
    }

    @XmlElement(name = "users")
    private TableauUserList payload;
}
