package sg.edu.nus.iss.vttp5a_ssf_day15wsA.controller.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.constant.Constant;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.service.ContactService;

@Controller
@RequestMapping("/contacts/create")
public class ContactsCreateController {
    
    @Autowired
    ContactService contactService;

    @GetMapping()
    public String createNewContact(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contactCreate";
    }

    @PostMapping()
    public String handleNewContactForm(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
        
        System.out.println("Recieved details: " + contact.toString());

        if (result.hasErrors()) {
            model.addAttribute("contact", contact);
            return "contactCreate";
        }

        Contact newContact = new Contact(contact.getName(), contact.getEmail(), contact.getPhone(), contact.getDob());
        contactService.addContact(Constant.CONTACTKEY, newContact);
        System.out.println("Created new contact: " + contact);
        
        return "redirect:/contacts";
    }
}
