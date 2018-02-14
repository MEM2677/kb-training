package it.keybiz.tableau.aps.system.services.tableau;

//import org.apache.http.impl.client.DefaultHttpClient;
import static it.keybiz.tableau.aps.system.services.tableau.TableauAuthenticationManager.TABLEAU_BASE_ADDRESS;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.entando.entando.plugins.jprestapi.aps.core.RequestBuilder;
import org.entando.entando.plugins.jprestapi.aps.core.helper.RequestHelper;

public class TableauRequestBuilder extends RequestBuilder {

    @Override
    protected void setupRequest(HttpRequestBase verb) throws Throwable {
        // process evaluation URL
        RequestHelper.addBaseUrl(verb, TABLEAU_BASE_ADDRESS);
    }

    @Override
    protected void setupOverallConnectionTimeout(DefaultHttpClient client) {
        client.getParams().setIntParameter(PARAM_TIMEOUT,
                TIMEOUT);

    }

    @Override
    protected DefaultHttpClient setupClient() {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        return httpclient;
    }
    
    public static final int TIMEOUT = 350;
}
