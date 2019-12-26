package com.eventoapp;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
	@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
//	@Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//	
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter(){
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(true);
//		adapter.setGenerateDdl(true);
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//		adapter.setPrepareConnection(true);
//		return adapter;
//	}
}
