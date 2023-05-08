package com.example.daycaree.Users;

import com.example.daycaree.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(nativeQuery = true, value = "Select COUNT(*) from Users where username = :username")
    Integer findUsersByUsername(@Param("username")String username);

    @Query(nativeQuery = true, value = "Select * from Users where username = :username or password = :password")
    Users Login(@Param("username")String username, @Param("password")String password);

    @Query(nativeQuery = true, value = "Select * from Users where username = :username ")
    Users Logins(@Param("username")String username);


}