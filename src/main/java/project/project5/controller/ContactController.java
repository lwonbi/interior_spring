package project.project5.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.project5.domain.Contact;
import project.project5.dto.ContactForm;
import project.project5.service.ContactService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/contact")
    public String contact(Model model){
        ContactForm contactForm = new ContactForm();
        contactForm.setNews(true);
        model.addAttribute("contactForm",contactForm);
        return "page/contact";
    }
    @PostMapping("contact")
    public String contactForm(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "page/contact";
        }
        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setMsg(contactForm.getMsg());
        contact.setNews(contactForm.isNews());
        contactService.join(contact);
        return "redirect:/contactList";
    }
    @GetMapping("/contactList")
    public String contactList(Model model){
        List<Contact> contactList = contactService.selectContact();
        model.addAttribute("contactList",contactList);
        return "page/contactList";
    }
}
