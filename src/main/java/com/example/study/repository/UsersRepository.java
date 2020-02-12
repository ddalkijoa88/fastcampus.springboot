package com.example.study.repository;

import com.example.study.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    //select * from users where account = ?
    Optional<Users> findByAccount(String account);
    Optional<Users> findByEmail(String email);

    //select * from users where account = ? and email = ?
    Optional<Users> findByAccountAndEmail(String account, String email);
}
