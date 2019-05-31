package u3f.rs.spring_sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import u3f.rs.spring_sample.security.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepo.findByUsername(username);
         if(user != null) {
             System.out.println(user.toString());
             return user;
         }
         throw new UsernameNotFoundException("User "+ username +" not found");
    }
}
