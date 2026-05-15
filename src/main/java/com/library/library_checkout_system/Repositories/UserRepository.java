package com.library.library_checkout_system.Repositories;

import com.library.library_checkout_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User getUserByUsername(String username);
}
