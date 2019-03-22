/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author sofieamalielandt
 */
public class DataSourceMySql
{

    private MysqlDataSource dataSource = new MysqlDataSource();

    /**
     * Initializes the information for connection to database.
     *
     */
    public DataSourceMySql()
    {
        try
        {
            dataSource.setServerName("157.230.97.130");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("LegoHouse");
            dataSource.setUser("amalie");
            dataSource.setPassword("sveske");
            dataSource.setUseSSL(false);

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * @return a dataSource with the specified information for connection.
     */
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
 
}
