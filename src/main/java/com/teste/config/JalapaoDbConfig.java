package com.teste.config;

import com.teste.repository.jalapaoBD.PessoaRepositoryJalapao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = PessoaRepositoryJalapao.class,
        entityManagerFactoryRef = "jalapaoEntityManager")
public class JalapaoDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "jalapao.datasource")
    public DataSource jalapaoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean jalapaoEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("jalapaoDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.teste.model.jalapaoBD")
                .build();
    }

}