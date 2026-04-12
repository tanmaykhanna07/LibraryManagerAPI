package com.library.library_checkout_system.Repositories;

import com.library.library_checkout_system.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {

}
