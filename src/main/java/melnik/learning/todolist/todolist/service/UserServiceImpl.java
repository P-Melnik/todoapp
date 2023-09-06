package melnik.learning.todolist.todolist.service;

import melnik.learning.todolist.todolist.dto.RegistrationDTO;
import melnik.learning.todolist.todolist.entity.Role;
import melnik.learning.todolist.todolist.entity.User;
import melnik.learning.todolist.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        List<Role> roles=new ArrayList<Role>();
        Role role=new Role();
        role.setName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.
                User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }



    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
