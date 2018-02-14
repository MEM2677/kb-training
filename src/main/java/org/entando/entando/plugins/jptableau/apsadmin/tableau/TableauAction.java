/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.apsadmin.tableau;

import org.entando.entando.plugins.jptableau.aps.system.services.tableau.Tableau;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.ITableauManager;



import com.agiletec.apsadmin.system.ApsAdminSystemConstants;
import com.agiletec.apsadmin.system.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableauAction extends BaseAction {

	private static final Logger _logger =  LoggerFactory.getLogger(TableauAction.class);

	public String newTableau() {
		try {
			this.setStrutsAction(ApsAdminSystemConstants.ADD);
		} catch (Throwable t) {
			_logger.error("error in newTableau", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String edit() {
		try {
			Tableau tableau = this.getTableauManager().getTableau(this.getId());
			if (null == tableau) {
				this.addActionError(this.getText("error.tableau.null"));
				return INPUT;
			}
			this.populateForm(tableau);
			this.setStrutsAction(ApsAdminSystemConstants.EDIT);
		} catch (Throwable t) {
			_logger.error("error in edit", t);
			return FAILURE;
		}
		return SUCCESS;
	}

	public String save() {
		try {
			Tableau tableau = this.createTableau();
			int strutsAction = this.getStrutsAction();
			if (ApsAdminSystemConstants.ADD == strutsAction) {
				this.getTableauManager().addTableau(tableau);
			} else if (ApsAdminSystemConstants.EDIT == strutsAction) {
				this.getTableauManager().updateTableau(tableau);
			}
		} catch (Throwable t) {
			_logger.error("error in save", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String trash() {
		try {
			Tableau tableau = this.getTableauManager().getTableau(this.getId());
			if (null == tableau) {
				this.addActionError(this.getText("error.tableau.null"));
				return INPUT;
			}
			this.populateForm(tableau);
			this.setStrutsAction(ApsAdminSystemConstants.DELETE);
		} catch (Throwable t) {
			_logger.error("error in trash", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String delete() {
		try {
			if (this.getStrutsAction() == ApsAdminSystemConstants.DELETE) {
				this.getTableauManager().deleteTableau(this.getId());
			}
		} catch (Throwable t) {
			_logger.error("error in delete", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	public String view() {
		try {
			Tableau tableau = this.getTableauManager().getTableau(this.getId());
			if (null == tableau) {
				this.addActionError(this.getText("error.tableau.null"));
				return INPUT;
			}
			this.populateForm(tableau);
		} catch (Throwable t) {
			_logger.error("error in view", t);
			return FAILURE;
		}
		return SUCCESS;
	}
	
	private void populateForm(Tableau tableau) throws Throwable {
		this.setId(tableau.getId());
		this.setName(tableau.getName());
		this.setSiterole(tableau.getSiterole());
		this.setAuthsetting(tableau.getAuthsetting());
		this.setLastlogin(tableau.getLastlogin());
	}
	
	private Tableau createTableau() {
		Tableau tableau = new Tableau();
		tableau.setId(this.getId());
		tableau.setName(this.getName());
		tableau.setSiterole(this.getSiterole());
		tableau.setAuthsetting(this.getAuthsetting());
		tableau.setLastlogin(this.getLastlogin());
		return tableau;
	}
	

	public int getStrutsAction() {
		return _strutsAction;
	}
	public void setStrutsAction(int strutsAction) {
		this._strutsAction = strutsAction;
	}
	
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

	
	protected ITableauManager getTableauManager() {
		return _tableauManager;
	}
	public void setTableauManager(ITableauManager tableauManager) {
		this._tableauManager = tableauManager;
	}
	
	private int _strutsAction;
	private int _id;
	private String _name;
	private String _siterole;
	private String _authsetting;
	private String _lastlogin;
	
	private ITableauManager _tableauManager;
	
}