package sg.edu.nus.iss.vttp5a_ssf_day15wsA.controller.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_ssf_day15wsA.constant.Constant;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.service.ContactService;

@Controller
@RequestMapping("/contacts/{id}/delete")
public class ContactsDeleteController {
    
    @Autowired
    ContactService contactService;

    @GetMapping()
    public String deleteContact(@PathVariable("id") String id, Model model) {
        Contact c = contactService.findByID(Constant.CONTACTKEY, id);
        model.addAttribute("contact", c);
        return "contactDelete";
    }

    @PostMapping()
    public String handleDeleteContact(@PathVariable("id") String id) {
        Contact contactToDelete = contactService.findByID(Constant.CONTACTKEY, id);
        contactService.removeContact(Constant.CONTACTKEY, contactToDelete);
        return "redirect:/contacts";
    }
}
