package sg.edu.nus.iss.vttp5a_ssf_day15wsA.controller.contacts;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_ssf_day15wsA.constant.Constant;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    
    @Autowired
    ContactService contactService;


    @GetMapping()
    public String contactsPage(Model model){
        List<Contact> contactList = contactService.getContactList(Constant.CONTACTKEY);
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
        model.addAttribute("contactList", contactList);
        return "contacts";
    }


    @GetMapping("/{id}")
    public String individualContactPage(@PathVariable String id, Model model) {
        Contact contact = contactService.findByID(Constant.CONTACTKEY, id);
            // formatting for different date view
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDob = contact.getDob().format(formatter);
            model.addAttribute("formattedDob", formattedDob);
        model.addAttribute("contact", contact);
        return "contactIndividual";
    }
}
