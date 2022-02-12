package fr.orsys.kingsley.ecommerce.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.orsys.kingsley.ecommerce.business.User;
import fr.orsys.kingsley.ecommerce.dao.UserDao;
import fr.orsys.kingsley.ecommerce.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userDao.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found! ");
		} else {
			return new UserDto(user);
		}
	}
}
