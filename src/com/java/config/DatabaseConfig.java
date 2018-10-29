package com.java.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.dto.Product;

@Configuration
@PropertySource(value="classpath:/database.properties")
@EnableTransactionManagement(proxyTargetClass=false)
public class DatabaseConfig {

	@Autowired Environment env;
	@Bean
	public DataSource getDs() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean bean= new LocalSessionFactoryBean();
		bean.setDataSource(getDs());
		bean.setHibernateProperties(hibernateProperties());
		bean.setAnnotatedClasses(Product.class, Account.class);
		bean.afterPropertiesSet();
		return bean.getObject();
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties= new Properties();
	//	properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
		properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
		properties.put(org.hibernate.cfg.Environment.AUTOCOMMIT, "false");
		return properties;
	}
	
	@Bean
	public HibernateTemplate getTemplate() throws IOException {
		HibernateTemplate template= new HibernateTemplate();
		template.setSessionFactory(sessionFactory());
		return template;
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager transactionManager() throws IOException {
		HibernateTransactionManager tx= new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory());
		return tx;
	}
}
