/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau;



public class Tableau {

	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}

	public String getSiterole() {
		return _siterole;
	}
	public void setSiterole(String siterole) {
		this._siterole = siterole;
	}

	public String getAuthsetting() {
		return _authsetting;
	}
	public void setAuthsetting(String authsetting) {
		this._authsetting = authsetting;
	}

	public String getLastlogin() {
		return _lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this._lastlogin = lastlogin;
	}

	
	private int _id;
	private String _name;
	private String _siterole;
	private String _authsetting;
	private String _lastlogin;

}
