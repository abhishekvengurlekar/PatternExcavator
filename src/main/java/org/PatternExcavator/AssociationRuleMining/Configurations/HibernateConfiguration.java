package org.PatternExcavator.AssociationRuleMining.Configurations;

import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Properties;

@Configuration
public class HibernateConfiguration {

    @Bean(name="factory")
    public SessionFactory sessionFactory(){

        Properties properties=new Properties();
        properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        properties.put(Environment.USER,"root");
        properties.put(Environment.PASS,"root");
        properties.put(Environment.URL,"jdbc:mysql://localhost:3306/mydb");
        properties.put(Environment.SHOW_SQL,"true");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");

        org.hibernate.cfg.Configuration configuration=new org.hibernate.cfg.Configuration();
        configuration.setProperties(properties).addAnnotatedClass(Company.class).addAnnotatedClass(Transaction.class).addAnnotatedClass(Product.class);

        ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(properties).build();
        SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;

    }




}
