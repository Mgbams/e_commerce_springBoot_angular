package fr.orsys.kingsley.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.kingsley.ecommerce.business.User;
import fr.orsys.kingsley.ecommerce.dto.UserDto;

public interface UserDao extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
