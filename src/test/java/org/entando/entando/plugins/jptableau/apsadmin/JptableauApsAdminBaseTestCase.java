/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.apsadmin;

import java.util.Properties;

import com.agiletec.ConfigTestUtils;
import com.agiletec.apsadmin.ApsAdminBaseTestCase;
import org.entando.entando.plugins.jptableau.JptableauConfigTestUtils;

public class JptableauApsAdminBaseTestCase extends ApsAdminBaseTestCase {

	@Override
	protected ConfigTestUtils getConfigUtils() {
		return new JptableauConfigTestUtils();
	}

    protected void setInitParameters(Properties params) {
    	params.setProperty("config", 
    				"struts-default.xml," +
    				"struts-plugin.xml," +
    				"struts.xml," +
    				"entando-struts-plugin.xml," +
    				"japs-struts-plugin.xml," +
    				CUSTOM_STRUTS_PLUGIN);
    }
    
    // TODO Edit this constant before running your junit test
    private static final String CUSTOM_STRUTS_PLUGIN = "change_me-jptableau-struts-plugin.xml";
}
