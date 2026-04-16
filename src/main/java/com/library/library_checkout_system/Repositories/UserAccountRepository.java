package com.library.library_checkout_system.Repositories;

import com.library.library_checkout_system.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
}
