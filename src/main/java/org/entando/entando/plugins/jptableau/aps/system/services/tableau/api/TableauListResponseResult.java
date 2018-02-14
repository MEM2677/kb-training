/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;
import org.entando.entando.aps.system.services.api.model.ListResponse;

@XmlSeeAlso({JAXBTableau.class})
public class TableauListResponseResult extends AbstractApiResponseResult {
    
    @XmlElement(name = "items", required = false)
    public ListResponse<JAXBTableau> getResult() {
        if (this.getMainResult() instanceof Collection) {
            List<JAXBTableau> tableaus = new ArrayList<JAXBTableau>();
            tableaus.addAll((Collection<JAXBTableau>) this.getMainResult());
            ListResponse<JAXBTableau> entity = new ListResponse<JAXBTableau>(tableaus) {};
            return entity;
        }
        return null;
    }

}