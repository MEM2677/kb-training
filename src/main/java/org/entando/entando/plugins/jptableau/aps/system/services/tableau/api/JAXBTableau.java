/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.api;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.entando.entando.plugins.jptableau.aps.system.services.tableau.Tableau;

@XmlRootElement(name = "tableau")
@XmlType(propOrder = {"id", "name", "siterole", "authsetting", "lastlogin"})
public class JAXBTableau {

    public JAXBTableau() {
        super();
    }

    public JAXBTableau(Tableau tableau) {
		this.setId(tableau.getId());
		this.setName(tableau.getName());
		this.setSiterole(tableau.getSiterole());
		this.setAuthsetting(tableau.getAuthsetting());
		this.setLastlogin(tableau.getLastlogin());
    }
    
    public Tableau getTableau() {
    	Tableau tableau = new Tableau();
		tableau.setId(this.getId());
		tableau.setName(this.getName());
		tableau.setSiterole(this.getSiterole());
		tableau.setAuthsetting(this.getAuthsetting());
		tableau.setLastlogin(this.getLastlogin());
    	return tableau;
    }

	@XmlElement(name = "id", required = true)
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	@XmlElement(name = "name", required = true)
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}

	@XmlElement(name = "siterole", required = true)
	public String getSiterole() {
		return _siterole;
	}
	public void setSiterole(String siterole) {
		this._siterole = siterole;
	}

	@XmlElement(name = "authsetting", required = true)
	public String getAuthsetting() {
		return _authsetting;
	}
	public void setAuthsetting(String authsetting) {
		this._authsetting = authsetting;
	}

	@XmlElement(name = "lastlogin", required = true)
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
