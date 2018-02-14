/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponse;
import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;


@XmlRootElement(name = "response")
public class TableauListResponse extends AbstractApiResponse {
    
    @Override
    @XmlElement(name = "result", required = true)
    public TableauListResponseResult getResult() {
        return (TableauListResponseResult) super.getResult();
    }
    
    @Override
    protected AbstractApiResponseResult createResponseResultInstance() {
        return new TableauListResponseResult();
    }
    
}