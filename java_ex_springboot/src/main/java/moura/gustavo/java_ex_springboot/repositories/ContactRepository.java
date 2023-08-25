package moura.gustavo.java_ex_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import moura.gustavo.java_ex_springboot.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
