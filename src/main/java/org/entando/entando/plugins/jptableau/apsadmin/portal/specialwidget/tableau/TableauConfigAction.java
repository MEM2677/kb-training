/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.apsadmin.portal.specialwidget.tableau;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.apsadmin.portal.specialwidget.SimpleWidgetConfigAction;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.ITableauManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableauConfigAction extends SimpleWidgetConfigAction {

	private static final Logger _logger =  LoggerFactory.getLogger(TableauConfigAction.class);
	
	protected String extractInitConfig() {
		String result = super.extractInitConfig();
		String id = this.getWidget().getConfig().getProperty("id");
		if (StringUtils.isNotBlank(id)) {
			this.setId(new Integer(id));
		}
		return result;
	}

	public List<Integer> getTableausId() {
		try {
			List<Integer> tableaus = this.getTableauManager().searchTableaus(null);
			return tableaus;
		} catch (Throwable t) {
			_logger.error("error in getTableausId", t);
			throw new RuntimeException("Error getting tableaus list", t);
		}
	}
	
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}

	protected ITableauManager getTableauManager() {
		return _tableauManager;
	}
	public void setTableauManager(ITableauManager tableauManager) {
		this._tableauManager = tableauManager;
	}

	private int _id;
	private ITableauManager _tableauManager;
}

