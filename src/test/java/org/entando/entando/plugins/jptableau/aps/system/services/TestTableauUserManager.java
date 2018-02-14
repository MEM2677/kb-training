/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services;

import java.util.List;
import org.entando.entando.plugins.jptableau.aps.JptableauBaseTestCase;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.ITableauUserManager;

public class TestTableauUserManager extends JptableauBaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.init();
	}


    public void testGetTableauUsers() throws Throwable {
        try {
            List<Integer> list = _tableauUserManager.getTableaus();
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }

 /*
	public void testGetTableau() {
		//TODO complete test
		assertNotNull(this._tableauUserManager);
	}

	public void testGetTableaus() {
		//TODO complete test
		assertNotNull(this._tableauUserManager);
	}

	public void testSearchTableaus() {
		//TODO complete test
		assertNotNull(this._tableauUserManager);
	}

	public void testAddTableau() {
		//TODO complete test
		assertNotNull(this._tableauUserManager);
	}

	public void testUpdateTableau() {
		//TODO complete test
		assertNotNull(this._tableauUserManager);
	}

	public void testDeleteTableau() {
		//TODO complete test
		assertNotNull(this._tableauUserManager);
	}
*/

	private void init() {
		//TODO add the spring bean id as constant
		this._tableauUserManager = (ITableauUserManager) this.getService("jptableauUserManager");
	}

	private ITableauUserManager _tableauUserManager;
}

