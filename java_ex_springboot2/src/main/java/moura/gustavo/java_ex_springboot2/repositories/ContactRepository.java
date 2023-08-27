package moura.gustavo.java_ex_springboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import moura.gustavo.java_ex_springboot2.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
