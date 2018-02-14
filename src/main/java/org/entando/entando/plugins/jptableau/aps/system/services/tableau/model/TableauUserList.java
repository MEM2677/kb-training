/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matteo
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableauUserList {

    public List<TableauUser> getUserList() {
        return userList;
    }

    public void setUserList(List<TableauUser> userList) {
        this.userList = userList;
    }

    @XmlElement(name = "user")
    private List<TableauUser> userList;

}
