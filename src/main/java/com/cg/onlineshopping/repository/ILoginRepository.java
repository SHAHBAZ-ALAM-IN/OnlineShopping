package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineshopping.entities.User;

public interface ILoginRepository extends JpaRepository<User, String> {

}
