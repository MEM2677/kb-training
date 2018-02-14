/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.services.tableau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.agiletec.aps.system.common.AbstractSearcherDAO;
import com.agiletec.aps.system.common.FieldSearchFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableauDAO extends AbstractSearcherDAO implements ITableauDAO {

	private static final Logger _logger =  LoggerFactory.getLogger(TableauDAO.class);

	@Override
	protected String getTableFieldName(String metadataFieldKey) {
		return metadataFieldKey;
	}
	
	@Override
	protected String getMasterTableName() {
		return "jptableau_tableau";
	}
	
	@Override
	protected String getMasterTableIdFieldName() {
		return "id";
	}
	
	@Override
	protected boolean isForceCaseInsensitiveLikeSearch() {
		return true;
	}

	@Override
	public List<Integer> searchTableaus(FieldSearchFilter[] filters) {
		List tableausId = null;
		try {
			tableausId  = super.searchId(filters);
		} catch (Throwable t) {
			_logger.error("error in searchTableaus",  t);
			throw new RuntimeException("error in searchTableaus", t);
		}
		return tableausId;
	}

	@Override
	public List<Integer> loadTableaus() {
		List<Integer> tableausId = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			stat = conn.prepareStatement(LOAD_TABLEAUS_ID);
			res = stat.executeQuery();
			while (res.next()) {
				int id = res.getInt("id");
				tableausId.add(id);
			}
		} catch (Throwable t) {
			_logger.error("Error loading Tableau list",  t);
			throw new RuntimeException("Error loading Tableau list", t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return tableausId;
	}
	
	@Override
	public void insertTableau(Tableau tableau) {
		PreparedStatement stat = null;
		Connection conn  = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.insertTableau(tableau, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error on insert tableau",  t);
			throw new RuntimeException("Error on insert tableau", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void insertTableau(Tableau tableau, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(ADD_TABLEAU);
			int index = 1;
			stat.setInt(index++, tableau.getId());
 			stat.setString(index++, tableau.getName());
 			stat.setString(index++, tableau.getSiterole());
 			stat.setString(index++, tableau.getAuthsetting());
 			stat.setString(index++, tableau.getLastlogin());
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error on insert tableau",  t);
			throw new RuntimeException("Error on insert tableau", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void updateTableau(Tableau tableau) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.updateTableau(tableau, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error updating tableau {}", tableau.getId(),  t);
			throw new RuntimeException("Error updating tableau", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}

	public void updateTableau(Tableau tableau, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE_TABLEAU);
			int index = 1;

 			stat.setString(index++, tableau.getName());
 			stat.setString(index++, tableau.getSiterole());
 			stat.setString(index++, tableau.getAuthsetting());
 			stat.setString(index++, tableau.getLastlogin());
			stat.setInt(index++, tableau.getId());
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error updating tableau {}", tableau.getId(),  t);
			throw new RuntimeException("Error updating tableau", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	@Override
	public void removeTableau(int id) {
		PreparedStatement stat = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			this.removeTableau(id, conn);
 			conn.commit();
		} catch (Throwable t) {
			this.executeRollback(conn);
			_logger.error("Error deleting tableau {}", id, t);
			throw new RuntimeException("Error deleting tableau", t);
		} finally {
			this.closeDaoResources(null, stat, conn);
		}
	}
	
	public void removeTableau(int id, Connection conn) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE_TABLEAU);
			int index = 1;
			stat.setInt(index++, id);
			stat.executeUpdate();
		} catch (Throwable t) {
			_logger.error("Error deleting tableau {}", id, t);
			throw new RuntimeException("Error deleting tableau", t);
		} finally {
			this.closeDaoResources(null, stat, null);
		}
	}

	public Tableau loadTableau(int id) {
		Tableau tableau = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			conn = this.getConnection();
			tableau = this.loadTableau(id, conn);
		} catch (Throwable t) {
			_logger.error("Error loading tableau with id {}", id, t);
			throw new RuntimeException("Error loading tableau with id " + id, t);
		} finally {
			closeDaoResources(res, stat, conn);
		}
		return tableau;
	}

	public Tableau loadTableau(int id, Connection conn) {
		Tableau tableau = null;
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			stat = conn.prepareStatement(LOAD_TABLEAU);
			int index = 1;
			stat.setInt(index++, id);
			res = stat.executeQuery();
			if (res.next()) {
				tableau = this.buildTableauFromRes(res);
			}
		} catch (Throwable t) {
			_logger.error("Error loading tableau with id {}", id, t);
			throw new RuntimeException("Error loading tableau with id " + id, t);
		} finally {
			closeDaoResources(res, stat, null);
		}
		return tableau;
	}

	protected Tableau buildTableauFromRes(ResultSet res) {
		Tableau tableau = null;
		try {
			tableau = new Tableau();				
			tableau.setId(res.getInt("id"));
			tableau.setName(res.getString("name"));
			tableau.setSiterole(res.getString("siterole"));
			tableau.setAuthsetting(res.getString("authsetting"));
			tableau.setLastlogin(res.getString("lastlogin"));
		} catch (Throwable t) {
			_logger.error("Error in buildTableauFromRes", t);
		}
		return tableau;
	}

	private static final String ADD_TABLEAU = "INSERT INTO jptableau_tableau (id, name, siterole, authsetting, lastlogin ) VALUES (?, ?, ?, ?, ? )";

	private static final String UPDATE_TABLEAU = "UPDATE jptableau_tableau SET  name=?,  siterole=?,  authsetting=?, lastlogin=? WHERE id = ?";

	private static final String DELETE_TABLEAU = "DELETE FROM jptableau_tableau WHERE id = ?";
	
	private static final String LOAD_TABLEAU = "SELECT id, name, siterole, authsetting, lastlogin  FROM jptableau_tableau WHERE id = ?";
	
	private static final String LOAD_TABLEAUS_ID  = "SELECT id FROM jptableau_tableau";
	
}