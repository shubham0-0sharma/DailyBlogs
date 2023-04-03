package com.noobdev.dailyblog.dailyblog.repositories;

import com.noobdev.dailyblog.dailyblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{


}
