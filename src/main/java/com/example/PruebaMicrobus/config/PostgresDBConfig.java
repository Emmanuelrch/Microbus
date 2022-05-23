package com.example.PruebaMicrobus.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "postgresEntityManagerFactory",
    basePackages = {"com.example.PruebaMicrobus"})
public class PostgresDBConfig {

  @Primary
  @Bean(name = "postgresDataSourceProperties")
  @ConfigurationProperties("postgres.datasource")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Primary
  @Bean(name = "postgresDataSource")
  @ConfigurationProperties("postgres.datasource.hikari")
  public DataSource dataSource(
      @Qualifier("postgresDataSourceProperties")
          DataSourceProperties postgresDataSourceProperties) {
    return postgresDataSourceProperties
        .initializeDataSourceBuilder()
        .type(HikariDataSource.class)
        .build();
  }

  @Primary
  @Bean(name = "postgresEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      EntityManagerFactoryBuilder builder,
      @Qualifier("postgresDataSource") DataSource postgresDataSource) {
    return builder
        .dataSource(postgresDataSource)
        .packages("com.example.PruebaMicrobus.model")
        .persistenceUnit("postgres")
        .build();
  }

  @Primary
  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(
      @Qualifier("postgresEntityManagerFactory")
          EntityManagerFactory postgresEntityManagerFactory) {
    return new JpaTransactionManager(postgresEntityManagerFactory);
  }
}
