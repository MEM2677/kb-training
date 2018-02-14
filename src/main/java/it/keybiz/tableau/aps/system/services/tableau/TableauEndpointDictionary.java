/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.keybiz.tableau.aps.system.services.tableau;

import static it.keybiz.tableau.aps.system.TableauSystemConstants.API_LOGIN;
import static it.keybiz.tableau.aps.system.TableauSystemConstants.GET_SITE_USERS;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.entando.entando.plugins.jprestapi.aps.core.Endpoint;
import org.entando.entando.plugins.jprestapi.aps.core.IEndpoint;

/**
 *
 * @author matteo
 */
public class TableauEndpointDictionary {


  private static HashMap<String, Endpoint> endpoints;

  private TableauEndpointDictionary() {}

  private static void init() {
        endpoints = new HashMap<>();

        endpoints.put(API_LOGIN, new Endpoint(IEndpoint.httpVerb.POST,   // VERB
                "api/%s/auth/signin",                                    // ENDPOINT
                HttpStatus.SC_OK));                                      // EXPECTED RESULT

        endpoints.put(GET_SITE_USERS, new Endpoint(IEndpoint.httpVerb.GET, "/api/%S/sites/%S/users", HttpStatus.SC_OK));



    }

    public static HashMap<String, Endpoint> create() {
        init();
        return endpoints;
}

}
