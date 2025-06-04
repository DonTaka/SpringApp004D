package com.example.SpringApp004D.Repository;

import com.example.SpringApp004D.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
