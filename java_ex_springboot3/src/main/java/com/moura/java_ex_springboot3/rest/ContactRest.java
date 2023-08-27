package com.moura.java_ex_springboot3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moura.java_ex_springboot3.entities.Contact;
import com.moura.java_ex_springboot3.repositories.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactRest {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Contact contact){
         contactRepository.save(contact);
    }

    @PutMapping
    public void update(@RequestBody Contact contact){
        if (contact.getId() != null){
            contactRepository.save(contact);
        }
    }

    @DeleteMapping
    public void deleteById(@RequestBody Long id){
        contactRepository.deleteById(id);
    }

}
