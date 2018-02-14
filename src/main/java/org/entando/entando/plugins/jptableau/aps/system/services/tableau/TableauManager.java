/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau;

import org.entando.entando.plugins.jptableau.aps.system.services.tableau.event.TableauChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Response;
import org.entando.entando.plugins.jptableau.aps.system.services.tableau.api.JAXBTableau;
import org.entando.entando.aps.system.services.api.IApiErrorCodes;
import org.entando.entando.aps.system.services.api.model.ApiException;

import com.agiletec.aps.system.common.FieldSearchFilter;
import com.agiletec.aps.system.common.AbstractService;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.services.keygenerator.IKeyGeneratorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableauManager extends AbstractService implements ITableauManager {

	private static final Logger _logger =  LoggerFactory.getLogger(TableauManager.class);

	@Override
	public void init() throws Exception {
		_logger.debug("{} ready.", this.getClass().getName());
	}
 
	@Override
	public Tableau getTableau(int id) throws ApsSystemException {
		Tableau tableau = null;
		try {
			tableau = this.getTableauDAO().loadTableau(id);
		} catch (Throwable t) {
			_logger.error("Error loading tableau with id '{}'", id,  t);
			throw new ApsSystemException("Error loading tableau with id: " + id, t);
		}
		return tableau;
	}

	@Override
	public List<Integer> getTableaus() throws ApsSystemException {
		List<Integer> tableaus = new ArrayList<Integer>();
		try {
			tableaus = this.getTableauDAO().loadTableaus();
		} catch (Throwable t) {
			_logger.error("Error loading Tableau list",  t);
			throw new ApsSystemException("Error loading Tableau ", t);
		}
		return tableaus;
	}

	@Override
	public List<Integer> searchTableaus(FieldSearchFilter filters[]) throws ApsSystemException {
		List<Integer> tableaus = new ArrayList<Integer>();
		try {
			tableaus = this.getTableauDAO().searchTableaus(filters);
		} catch (Throwable t) {
			_logger.error("Error searching Tableaus", t);
			throw new ApsSystemException("Error searching Tableaus", t);
		}
		return tableaus;
	}

	@Override
	public void addTableau(Tableau tableau) throws ApsSystemException {
		try {
			int key = this.getKeyGeneratorManager().getUniqueKeyCurrentValue();
			tableau.setId(key);
			this.getTableauDAO().insertTableau(tableau);
			this.notifyTableauChangedEvent(tableau, TableauChangedEvent.INSERT_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error adding Tableau", t);
			throw new ApsSystemException("Error adding Tableau", t);
		}
	}
 
	@Override
	public void updateTableau(Tableau tableau) throws ApsSystemException {
		try {
			this.getTableauDAO().updateTableau(tableau);
			this.notifyTableauChangedEvent(tableau, TableauChangedEvent.UPDATE_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error updating Tableau", t);
			throw new ApsSystemException("Error updating Tableau " + tableau, t);
		}
	}

	@Override
	public void deleteTableau(int id) throws ApsSystemException {
		try {
			Tableau tableau = this.getTableau(id);
			this.getTableauDAO().removeTableau(id);
			this.notifyTableauChangedEvent(tableau, TableauChangedEvent.REMOVE_OPERATION_CODE);
		} catch (Throwable t) {
			_logger.error("Error deleting Tableau with id {}", id, t);
			throw new ApsSystemException("Error deleting Tableau with id:" + id, t);
		}
	}


	/**
	 * GET http://localhost:8080/<portal>/api/rs/en/tableaus?
	 * @param properties
	 * @return
	 * @throws Throwable
	 */
	public List<JAXBTableau> getTableausForApi(Properties properties) throws Throwable {
		List<JAXBTableau> list = new ArrayList<JAXBTableau>();
		List<Integer> idList = this.getTableaus();
		if (null != idList && !idList.isEmpty()) {
			Iterator<Integer> tableauIterator = idList.iterator();
			while (tableauIterator.hasNext()) {
				int currentid = tableauIterator.next();
				Tableau tableau = this.getTableau(currentid);
				if (null != tableau) {
					list.add(new JAXBTableau(tableau));
				}
			}
		}
		return list;
	}

	/**
	 * GET http://localhost:8080/<portal>/api/rs/en/tableau?id=1
	 * @param properties
	 * @return
	 * @throws Throwable
	 */
    public JAXBTableau getTableauForApi(Properties properties) throws Throwable {
        String idString = properties.getProperty("id");
        int id = 0;
		JAXBTableau jaxbTableau = null;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new ApiException(IApiErrorCodes.API_PARAMETER_VALIDATION_ERROR, "Invalid Integer format for 'id' parameter - '" + idString + "'", Response.Status.CONFLICT);
        }
        Tableau tableau = this.getTableau(id);
        if (null == tableau) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Tableau with id '" + idString + "' does not exist", Response.Status.CONFLICT);
        }
        jaxbTableau = new JAXBTableau(tableau);
        return jaxbTableau;
    }

    /**
     * POST Content-Type: application/xml http://localhost:8080/<portal>/api/rs/en/tableau 
     * @param jaxbTableau
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void addTableauForApi(JAXBTableau jaxbTableau) throws ApiException, ApsSystemException {
        if (null != this.getTableau(jaxbTableau.getId())) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Tableau with id " + jaxbTableau.getId() + " already exists", Response.Status.CONFLICT);
        }
        Tableau tableau = jaxbTableau.getTableau();
        this.addTableau(tableau);
    }

    /**
     * PUT Content-Type: application/xml http://localhost:8080/<portal>/api/rs/en/tableau 
     * @param jaxbTableau
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void updateTableauForApi(JAXBTableau jaxbTableau) throws ApiException, ApsSystemException {
        if (null == this.getTableau(jaxbTableau.getId())) {
            throw new ApiException(IApiErrorCodes.API_VALIDATION_ERROR, "Tableau with id " + jaxbTableau.getId() + " does not exist", Response.Status.CONFLICT);
        }
        Tableau tableau = jaxbTableau.getTableau();
        this.updateTableau(tableau);
    }

    /**
     * DELETE http://localhost:8080/<portal>/api/rs/en/tableau?id=1
	 * @param properties
     * @throws ApiException
     * @throws ApsSystemException
     */
    public void deleteTableauForApi(Properties properties) throws Throwable {
        String idString = properties.getProperty("id");
        int id = 0;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new ApiException(IApiErrorCodes.API_PARAMETER_VALIDATION_ERROR, "Invalid Integer format for 'id' parameter - '" + idString + "'", Response.Status.CONFLICT);
        }
        this.deleteTableau(id);
    }

	private void notifyTableauChangedEvent(Tableau tableau, int operationCode) {
		TableauChangedEvent event = new TableauChangedEvent();
		event.setTableau(tableau);
		event.setOperationCode(operationCode);
		this.notifyEvent(event);
	}


	protected IKeyGeneratorManager getKeyGeneratorManager() {
		return _keyGeneratorManager;
	}
	public void setKeyGeneratorManager(IKeyGeneratorManager keyGeneratorManager) {
		this._keyGeneratorManager = keyGeneratorManager;
	}

	public void setTableauDAO(ITableauDAO tableauDAO) {
		 this._tableauDAO = tableauDAO;
	}
	protected ITableauDAO getTableauDAO() {
		return _tableauDAO;
	}

	private IKeyGeneratorManager _keyGeneratorManager;
	private ITableauDAO _tableauDAO;
}
