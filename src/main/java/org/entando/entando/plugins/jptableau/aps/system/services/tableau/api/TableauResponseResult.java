/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.api;

import javax.xml.bind.annotation.XmlElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;


public class TableauResponseResult extends AbstractApiResponseResult {
    
    @Override
    @XmlElement(name = "tableau", required = false)
    public JAXBTableau getResult() {
        return (JAXBTableau) this.getMainResult();
    }
    
}