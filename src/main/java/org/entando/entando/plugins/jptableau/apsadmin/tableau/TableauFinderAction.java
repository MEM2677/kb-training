/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.apsadmin.tableau;

import java.util.List;
import org.apache.commons.lang.StringUtils;

import com.agiletec.aps.system.common.FieldSearchFilter;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.Tableau;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.ITableauManager;
import com.agiletec.apsadmin.system.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableauFinderAction extends BaseAction {

	private static final Logger _logger =  LoggerFactory.getLogger(TableauFinderAction.class);

	public List<Integer> getTableausId() {
		try {
			FieldSearchFilter[] filters = new FieldSearchFilter[0];
			if (null != this.getId()) {
				//TODO add a constant into your ITableauManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("id"), this.getId(), false);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (StringUtils.isNotBlank(this.getName())) {
				//TODO add a constant into your ITableauManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("name"), this.getName(), true);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (StringUtils.isNotBlank(this.getSiterole())) {
				//TODO add a constant into your ITableauManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("siterole"), this.getSiterole(), true);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (StringUtils.isNotBlank(this.getAuthsetting())) {
				//TODO add a constant into your ITableauManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("authsetting"), this.getAuthsetting(), true);
				filters = this.addFilter(filters, filterToAdd);
			}
			if (StringUtils.isNotBlank(this.getLastlogin())) {
				//TODO add a constant into your ITableauManager class
				FieldSearchFilter filterToAdd = new FieldSearchFilter(("lastlogin"), this.getLastlogin(), true);
				filters = this.addFilter(filters, filterToAdd);
			}
			List<Integer> tableaus = this.getTableauManager().searchTableaus(filters);
			return tableaus;
		} catch (Throwable t) {
			_logger.error("Error getting tableaus list", t);
			throw new RuntimeException("Error getting tableaus list", t);
		}
	}

	protected FieldSearchFilter[] addFilter(FieldSearchFilter[] filters, FieldSearchFilter filterToAdd) {
		int len = filters.length;
		FieldSearchFilter[] newFilters = new FieldSearchFilter[len + 1];
		for(int i=0; i < len; i++){
			newFilters[i] = filters[i];
		}
		newFilters[len] = filterToAdd;
		return newFilters;
	}

	public Tableau getTableau(int id) {
		Tableau tableau = null;
		try {
			tableau = this.getTableauManager().getTableau(id);
		} catch (Throwable t) {
			_logger.error("Error getting tableau with id {}", id, t);
			throw new RuntimeException("Error getting tableau with id " + id, t);
		}
		return tableau;
	}


	public Integer getId() {
		return _id;
	}
	public void setId(Integer id) {
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
	
	private Integer _id;
	private String _name;
	private String _siterole;
	private String _authsetting;
	private String _lastlogin;
	private ITableauManager _tableauManager;
}