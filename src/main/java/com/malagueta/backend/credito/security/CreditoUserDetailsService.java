package com.malagueta.backend.credito.security;

import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CreditoUserDetailsService  implements UserDetailsService {
 @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //ler sobre o uso da condicao optional
        User user= userRepository.findByName(username);
        System.out.println(username);
        if (user==null) {
            System.out.println("utilizador: "+username+" nao encontrado");
         throw new UsernameNotFoundException("utilizador nao encontrado");
        }

        System.out.println("utilizador: "+user);
        return new org.springframework.security.core.userdetails.User("{noop}"+user.getName(),
                "{noop}"+user.getSenha(),
                getPermissoes(user));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(User user) {
        Set<SimpleGrantedAuthority> authoritys=new HashSet<>();
         user.getRoles().forEach(role -> authoritys.add(new SimpleGrantedAuthority(role.getDescricao())));
        return authoritys;

    }

}
