package com.moura.java_ex_springboot3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moura.java_ex_springboot3.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
