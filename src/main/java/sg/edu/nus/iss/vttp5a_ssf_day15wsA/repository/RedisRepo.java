package sg.edu.nus.iss.vttp5a_ssf_day15wsA.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day15wsA.constant.Constant;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.model.Contact;

@Repository
public class RedisRepo {
    
    @Autowired
    @Qualifier(Constant.CONTACTTEMPLATE)
    RedisTemplate<String, String> template;

    // get contacts list function
    public List<Contact> getContactList(String key) {
        
        List<String> contactListString = template.opsForList().range(key, 0, -1);

        List<Contact> contactList = new ArrayList<>();

        for (String contact : contactListString) {
            String[] data = contact.split(",");
            Contact c = new Contact(data[0], data[1], data[2], data[3], LocalDate.parse(data[4]));
            contactList.add(c);
        }

        return contactList;
    }


    // add contact function
    public void addContact(String key, Contact c){
        String contact = c.toString();
        template.opsForList().rightPush(key, contact);
    }


    // find contact by ID function
    public Contact findByID(String key, String id){
        List<Contact> contactList = getContactList(key);
        for (Contact contact : contactList) {
            if (contact.getId().equals(id)){
                return contact;
            }
        }
        return null;
    }


    // remove contact function
    public void removeContact(String key, Contact c){
        String contact = c.toString();
        template.opsForList().remove(key, 1, contact);
    }


    // update contact function
    public void updateContact(String key, Contact c) {
        Contact contactToUpdate = findByID(key, c.getId());
        if (contactToUpdate != null) {
            removeContact(key, contactToUpdate);
        }
        addContact(key, c);
    }
}
