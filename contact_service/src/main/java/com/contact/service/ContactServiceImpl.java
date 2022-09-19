package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements IContactService{


    List<Contact> contactList = List.of(
      new Contact(22L, "ankit@gmail", "ankit", 1L),
            new Contact(33L, "jimmy@gmail", "jimmy", 2L),
            new Contact(44L, "raga@gmail", "raga", 1L)

    );

    @Override
    public List<Contact> getContacts(Long userId) {
        return contactList.stream()
                .filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
