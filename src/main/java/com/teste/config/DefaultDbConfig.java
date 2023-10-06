package com.teste.config;

import com.teste.repository.defaultBD.PessoaRepositoryDefault;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = PessoaRepositoryDefault.class,
        entityManagerFactoryRef = "defaultEntityManager")
public class DefaultDbConfig {

    @Bean
    @Primary //se houver apenas uma instância de entity manager, este será o primário
    @ConfigurationProperties(prefix = "default.datasource")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean defaultEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("defaultDataSource") DataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages("com.teste.model.defaultBD")
                .build();
    }
}