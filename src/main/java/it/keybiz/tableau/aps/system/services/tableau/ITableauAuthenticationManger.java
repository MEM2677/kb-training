package it.keybiz.tableau.aps.system.services.tableau;

import com.agiletec.aps.system.exception.ApsSystemException;
import it.keybiz.tableau.aps.system.services.tableau.model.TableauLoginRequest;
import it.keybiz.tableau.aps.system.services.tableau.model.TableauLoginResponse;

public interface ITableauAuthenticationManger {

    public TableauLoginResponse login(TableauLoginRequest credentials) throws ApsSystemException;

}
