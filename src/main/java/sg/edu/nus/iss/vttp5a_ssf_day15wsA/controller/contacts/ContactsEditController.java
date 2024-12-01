package sg.edu.nus.iss.vttp5a_ssf_day15wsA.controller.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.constant.Constant;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.model.Contact;
import sg.edu.nus.iss.vttp5a_ssf_day15wsA.service.ContactService;

@Controller
@RequestMapping("/contacts/{id}/edit")
public class ContactsEditController {
    
    @Autowired
    ContactService contactService;

    @GetMapping()
    public String updateContact(@PathVariable("id") String id, Model model) {
        Contact c = contactService.findByID(Constant.CONTACTKEY, id);
        model.addAttribute("contact", c);
        return "contactUpdate";
    }

    @PostMapping()
    public String handleUpdateContact(@PathVariable("id") String id, @Valid @ModelAttribute Contact contact, BindingResult result, Model model) {

        // validate fields
        if (result.hasErrors()) {
            model.addAttribute("contact", contact);
            return "contactUpdate";
        }

        contactService.updateContact(Constant.CONTACTKEY, contact);
        System.out.println("Updated contact: " + contact);

        return "redirect:/contacts/" + id;
    }
}
