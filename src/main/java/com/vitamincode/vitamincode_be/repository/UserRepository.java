package com.vitamincode.vitamincode_be.repository;

import com.vitamincode.vitamincode_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
