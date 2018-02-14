/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau;

import java.util.List;
import com.agiletec.aps.system.exception.ApsSystemException;

import com.agiletec.aps.system.common.FieldSearchFilter;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.model.TableauLoginResponse;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.model.TableauUser;

public interface ITableauUserManager {

    public List<TableauUser> getUsers(TableauLoginResponse credentials) throws ApsSystemException;

	public Tableau getTableau(int id) throws ApsSystemException;

	public List<Integer> getTableaus() throws ApsSystemException;

	public List<Integer> searchTableaus(FieldSearchFilter filters[]) throws ApsSystemException;

	public void addTableau(Tableau tableau) throws ApsSystemException;

	public void updateTableau(Tableau tableau) throws ApsSystemException;

	public void deleteTableau(int id) throws ApsSystemException;

}