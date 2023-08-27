package moura.gustavo.java_ex_springboot4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import moura.gustavo.java_ex_springboot4.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
