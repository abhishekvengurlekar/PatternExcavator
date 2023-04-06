package org.PatternExcavator.AssociationRuleMining.SpringSecurity;

import org.PatternExcavator.AssociationRuleMining.DAO.SpringSecurityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class HibernateUserDetailsService implements UserDetailsService {

    @Autowired
    SpringSecurityDAO springSecurityDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LightWeightCompany company=springSecurityDAO.loadUserByUserName(username);

        if(company==null){

            throw new UsernameNotFoundException("Could not find User in the DataBase");
        }

        UserDetails userDetails=User.withUsername(company.getCompanyName())
                                    .password(company.getCompanyPassword())
                                    .authorities(company.getAuthority())
                                    .build();


        return userDetails;

    }
}
