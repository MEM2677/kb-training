/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services;

import org.entando.entando.plugins.jptableau.aps.JptableauBaseTestCase;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.ITableauAuthenticationManger;

public class TestTableauAuthenticationManager extends JptableauBaseTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.init();
	}

	public void testGetTableau() {
		//TODO complete test
		assertNotNull(this._authenticationManger);
	}

	public void testGetTableaus() {
		//TODO complete test
		assertNotNull(this._authenticationManger);
	}

	public void testSearchTableaus() {
		//TODO complete test
		assertNotNull(this._authenticationManger);
	}

	public void testAddTableau() {
		//TODO complete test
		assertNotNull(this._authenticationManger);
	}

	public void testUpdateTableau() {
		//TODO complete test
		assertNotNull(this._authenticationManger);
	}

	public void testDeleteTableau() {
		//TODO complete test
		assertNotNull(this._authenticationManger);
	}

	private void init() {
		//TODO add the spring bean id as constant
		this._authenticationManger = (ITableauAuthenticationManger) this.getService("jptableauAuthManager");
	}

	private ITableauAuthenticationManger _authenticationManger;
}

