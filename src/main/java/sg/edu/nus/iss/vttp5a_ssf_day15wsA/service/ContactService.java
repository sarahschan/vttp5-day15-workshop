package sg.edu.nus.iss.vttp5a_ssf_day15wsA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day15wsA.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.repository.RedisRepo;

@Service
public class ContactService {
    
    @Autowired
    RedisRepo redisRepo;

    public List<Contact> getContactList(String key) {
        return redisRepo.getContactList(key);
    }

    public void addContact(String key, Contact c) {
        redisRepo.addContact(key, c);
    }

    public Contact findByID(String key, String id) {
        return redisRepo.findByID(key, id);
    }

    public void removeContact(String key, Contact c) {
        redisRepo.removeContact(key, c);
    }

    public void updateContact(String key, Contact c) {
        redisRepo.updateContact(key, c);
    }
}
