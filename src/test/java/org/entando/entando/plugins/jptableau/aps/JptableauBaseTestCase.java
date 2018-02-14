/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps;


import org.entando.entando.plugins.jptableau.JptableauConfigTestUtils;

import com.agiletec.ConfigTestUtils;
import com.agiletec.aps.BaseTestCase;

public class JptableauBaseTestCase extends BaseTestCase {

	@Override
	protected ConfigTestUtils getConfigUtils() {
		return new JptableauConfigTestUtils();
	}

	
}
