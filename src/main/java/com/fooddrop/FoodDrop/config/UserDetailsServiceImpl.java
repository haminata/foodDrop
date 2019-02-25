//package com.fooddrop.FoodDrop.config;
//
//import com.fooddrop.FoodDrop.model.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    public BCryptPasswordEncoder encoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        final List<Customer> user = Arrays.asList();
//
//        for(Customer customer:user){
//            if (customer.getEmail().equals(username)){
//                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                        .commaSeparatedStringToAuthorityList("ROLE_" + customer.getRole());
//                return new User(customer.getUsername(), customer.getPassword(), grantedAuthorities);
//            }
//
//        }
//
//
//
//        throw new UsernameNotFoundException("Username: " + username + " not found");
//    }
//}
