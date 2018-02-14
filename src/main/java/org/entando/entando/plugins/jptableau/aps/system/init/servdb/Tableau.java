/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jptableau.aps.system.init.servdb;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Tableau.TABLE_NAME)
public class Tableau {
	
	public Tableau() {}
	
	@DatabaseField(columnName = "id", 
		dataType = DataType.INTEGER, 
		 canBeNull=false, id = true)
	private int _id;
	
	@DatabaseField(columnName = "name", 
		dataType = DataType.STRING, 
		width=60,  canBeNull=false)
	private String _name;
	
	@DatabaseField(columnName = "siterole", 
		dataType = DataType.STRING, 
		width=60,  canBeNull=false)
	private String _siterole;
	
	@DatabaseField(columnName = "authsetting", 
		dataType = DataType.STRING, 
		width=60,  canBeNull=false)
	private String _authsetting;
	
	@DatabaseField(columnName = "lastlogin", 
		dataType = DataType.STRING, 
		width=60,  canBeNull=false)
	private String _lastlogin;
	

public static final String TABLE_NAME = "jptableau_tableau";
}
