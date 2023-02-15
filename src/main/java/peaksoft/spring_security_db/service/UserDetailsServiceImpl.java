package peaksoft.spring_security_db.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import peaksoft.spring_security_db.entity.MyUser;
import peaksoft.spring_security_db.entity.User;
import peaksoft.spring_security_db.reposirory.UserRepository;
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("could not find user");
        }
        return new MyUser(user);
    }
}
