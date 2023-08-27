package moura.gustavo.java_ex_springboot4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moura.gustavo.java_ex_springboot4.entities.Contact;
import moura.gustavo.java_ex_springboot4.repositories.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactRest {
    
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> listarTodos(){
        return contactRepository.findAll();
    }

    @PostMapping
    public void inserir(@RequestBody Contact contact){
        contactRepository.save(contact);
    }

    @PutMapping
    public void update(@RequestBody Contact contact){
        if (contact.getId() != null){
            contactRepository.save(contact);
        }
    }

    @DeleteMapping
    public void deleteById(@RequestBody Contact contact){
        contactRepository.delete(contact);
    }
    

}
