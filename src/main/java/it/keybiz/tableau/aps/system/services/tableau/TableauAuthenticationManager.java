package it.keybiz.tableau.aps.system.services.tableau;

import com.agiletec.aps.system.common.AbstractService;
import com.agiletec.aps.system.exception.ApsSystemException;
import static it.keybiz.tableau.aps.system.TableauSystemConstants.API_LOGIN;
import static it.keybiz.tableau.aps.system.TableauSystemConstants.GET_SITE_USERS;
import it.keybiz.tableau.aps.system.services.tableau.model.TableauLoginRequest;
import it.keybiz.tableau.aps.system.services.tableau.model.TableauLoginResponse;
import it.keybiz.tableau.aps.system.services.tableau.model.TableauUser;
import it.keybiz.tableau.aps.system.services.tableau.model.TableauUserListResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.entando.entando.plugins.jprestapi.aps.core.Endpoint;
import org.entando.entando.plugins.jprestapi.aps.core.helper.JAXBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableauAuthenticationManager extends AbstractService implements ITableauAuthenticationManger {

    private static final Logger _logger = LoggerFactory.getLogger(TableauAuthenticationManager.class);

    @Override
    public void init() throws Exception {
        _logger.info(this.getClass().getCanonicalName() + ": service loaded");

        TableauLoginRequest credentials = new TableauLoginRequest(
                "info4sales-trello@yahoo.it",
                "adminadmin1",
                "kbtraining");

        TableauLoginResponse login = login(credentials);
        List<TableauUser> users = getUsers(login);
        System.out.println(">>> " + users.get(1).getName());
    }

    @Override
    public TableauLoginResponse login(TableauLoginRequest credentials) throws ApsSystemException {
        Map<String, String> headersMap = new HashMap();

        try {

            // resolve API version
            Endpoint ep = TableauEndpointDictionary.create().get(API_LOGIN)
                    .resolveParams(API_VERSION_SUPPORTED);
            // prepare header
            headersMap.put("Content-Type", "application/json");
            headersMap.put("Accept", "application/json");   // not really needed

            TableauLoginResponse login = (TableauLoginResponse) new TableauRequestBuilder()
                    .setEndpoint(ep)
                    .setHeaders(headersMap)
                    .setPayload(JAXBHelper.marshall(credentials, true, true))
                    .setUnmarshalOptions(true, true)
//                    .setDebug(true)
//                    .setTestMode(true)
                    .doRequest(TableauLoginResponse.class);
            return login;
        } catch (Throwable t) {
            _logger.error("error in login", t);
            throw new ApsSystemException("error in login", t);
        }
    }


    public List<TableauUser> getUsers(TableauLoginResponse credentials) throws ApsSystemException {
        Map<String, String> headersMap = new HashMap();
        List<TableauUser> users = new ArrayList<>();
        try {

            // resolve API version
            Endpoint ep = TableauEndpointDictionary.create().get(GET_SITE_USERS)
                    .resolveParams(API_VERSION_SUPPORTED,
                            credentials.getSite().getId());
            // prepare header
            headersMap.put("Content-Type", "application/json");
            headersMap.put("Accept", "application/json");   // not really needed
            headersMap.put("X-Tableau-Auth", credentials.getToken());

            TableauUserListResponse list = (TableauUserListResponse) new TableauRequestBuilder()
                    .setEndpoint(ep)
                    .setHeaders(headersMap)
                    .setUnmarshalOptions(true, false)
                    .setDebug(true)
//                    .setTestMode(true)
                    .doRequest(TableauUserListResponse.class);

            if (null != list
                    && null != list.getPayload()) {
                users = list.getPayload().getUserList();
            }
        } catch (Throwable t) {
            _logger.error("error getting user list", t);
            throw new ApsSystemException("error getting user list", t);
        }
        return users;
    }


    public final static String API_VERSION_SUPPORTED = "2.8";

    // assigned by Tableau upon account creation
    public final static String TABLEAU_BASE_ADDRESS = "https://dub01.online.tableau.com/";

}
