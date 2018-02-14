/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau;

import java.util.List;

import com.agiletec.aps.system.common.FieldSearchFilter;

public interface ITableauDAO {

	public List<Integer> searchTableaus(FieldSearchFilter[] filters);
	
	public Tableau loadTableau(int id);

	public List<Integer> loadTableaus();

	public void removeTableau(int id);
	
	public void updateTableau(Tableau tableau);

	public void insertTableau(Tableau tableau);
	

}