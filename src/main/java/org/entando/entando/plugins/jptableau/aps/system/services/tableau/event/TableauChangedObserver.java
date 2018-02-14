/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau.event;

import com.agiletec.aps.system.common.notify.ObserverService;

public interface TableauChangedObserver extends ObserverService {
	
	public void updateFromTableauChanged(TableauChangedEvent event);
	
}
