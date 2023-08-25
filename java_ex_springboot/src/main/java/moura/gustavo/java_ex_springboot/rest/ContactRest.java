package moura.gustavo.java_ex_springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moura.gustavo.java_ex_springboot.entities.Contact;
import moura.gustavo.java_ex_springboot.repositories.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactRest {
    
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> listar(){
        return contactRepository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contact contact){
        contactRepository.save(contact);
    }

    @PutMapping
    public void alterar(@RequestBody Contact contact){
        if (contact.getId() != null){
            contactRepository.save(contact);
        }
    }

    @DeleteMapping
    public void excluir(@RequestBody Contact contact){
        contactRepository.delete(contact);
    }
    

}
