package org.entando.entando.plugins.jptableau.aps.system.services.tableau;

import com.agiletec.aps.system.exception.ApsSystemException;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.model.TableauLoginResponse;

public interface ITableauAuthenticationManger {

    public TableauLoginResponse login() throws ApsSystemException;

}
