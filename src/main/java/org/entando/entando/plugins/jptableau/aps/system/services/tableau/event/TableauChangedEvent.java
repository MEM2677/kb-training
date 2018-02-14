/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.event;

import com.agiletec.aps.system.common.IManager;
import com.agiletec.aps.system.common.notify.ApsEvent;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.Tableau;


public class TableauChangedEvent extends ApsEvent {
	
	@Override
	public void notify(IManager srv) {
		((TableauChangedObserver) srv).updateFromTableauChanged(this);
	}
	
	@Override
	public Class getObserverInterface() {
		return TableauChangedObserver.class;
	}
	
	public int getOperationCode() {
		return _operationCode;
	}
	public void setOperationCode(int operationCode) {
		this._operationCode = operationCode;
	}
	
	public Tableau getTableau() {
		return _tableau;
	}
	public void setTableau(Tableau tableau) {
		this._tableau = tableau;
	}

	private Tableau _tableau;
	private int _operationCode;
	
	public static final int INSERT_OPERATION_CODE = 1;
	public static final int REMOVE_OPERATION_CODE = 2;
	public static final int UPDATE_OPERATION_CODE = 3;

}
