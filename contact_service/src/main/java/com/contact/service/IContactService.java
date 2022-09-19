package com.contact.service;

import com.contact.entity.Contact;

import java.util.List;

public interface IContactService {

    public List<Contact> getContacts(Long userId);
 }
