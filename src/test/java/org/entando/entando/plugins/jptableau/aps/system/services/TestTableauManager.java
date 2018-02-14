/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services;

import org.entando.entando.plugins.jptableau.aps.JptableauBaseTestCase;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.ITableauManager;

public class TestTableauManager extends JptableauBaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.init();
	}
	
	public void testGetTableau() {
		//TODO complete test
		assertNotNull(this._tableauManager);
	}

	public void testGetTableaus() {
		//TODO complete test
		assertNotNull(this._tableauManager);
	}
	
	public void testSearchTableaus() {
		//TODO complete test
		assertNotNull(this._tableauManager);
	}

	public void testAddTableau() {
		//TODO complete test
		assertNotNull(this._tableauManager);
	}

	public void testUpdateTableau() {
		//TODO complete test
		assertNotNull(this._tableauManager);
	}

	public void testDeleteTableau() {
		//TODO complete test
		assertNotNull(this._tableauManager);
	}
	
	private void init() {
		//TODO add the spring bean id as constant
		this._tableauManager = (ITableauManager) this.getService("jptableauTableauManager");
	}
	
	private ITableauManager _tableauManager;
}

