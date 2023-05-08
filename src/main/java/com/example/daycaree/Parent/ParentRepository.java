package com.example.daycaree.Parent;

import com.example.daycaree.Child.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query(nativeQuery = true, value = "Select COUNT(*) from parent where firstname = :firstname AND lastname = :lastname")
    Integer findByFirstnameAndLastname(@Param("firstname")String firstname, @Param("lastname")String lastname);

    @Query(nativeQuery = true, value = "Select * from Parent ")
    List<Parent> FindAllParent();



}