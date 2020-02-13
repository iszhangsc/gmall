
package com.generator.config;

import com.generator.dao.GeneratorDao;
import com.generator.dao.MySQLGeneratorDao;
import com.generator.dao.OracleGeneratorDao;
import com.generator.dao.PostgreSQLGeneratorDao;
import com.generator.dao.SQLServerGeneratorDao;
import com.generator.utils.RRException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库配置
 *
 * @author Mark sunlightcs@gmail.com
 */
@Configuration
public class DbConfig {

    @Value("${database.platform}")
    private String database;

    private final MySQLGeneratorDao mySQLGeneratorDao;
    private final OracleGeneratorDao oracleGeneratorDao;
    private final SQLServerGeneratorDao sqlServerGeneratorDao;
    private final PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    public DbConfig(MySQLGeneratorDao mySQLGeneratorDao, OracleGeneratorDao oracleGeneratorDao,
                    SQLServerGeneratorDao sqlServerGeneratorDao, PostgreSQLGeneratorDao postgreSQLGeneratorDao) {
        this.mySQLGeneratorDao = mySQLGeneratorDao;
        this.oracleGeneratorDao = oracleGeneratorDao;
        this.sqlServerGeneratorDao = sqlServerGeneratorDao;
        this.postgreSQLGeneratorDao = postgreSQLGeneratorDao;
    }

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao(){
        if("mysql".equalsIgnoreCase(database)){
            return mySQLGeneratorDao;
        }else if("oracle".equalsIgnoreCase(database)){
            return oracleGeneratorDao;
        }else if("sqlserver".equalsIgnoreCase(database)){
            return sqlServerGeneratorDao;
        }else if("postgresql".equalsIgnoreCase(database)){
            return postgreSQLGeneratorDao;
        }else {
            throw new RRException("不支持当前数据库：" + database);
        }
    }

}
