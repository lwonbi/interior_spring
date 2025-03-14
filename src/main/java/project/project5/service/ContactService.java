package project.project5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.project5.domain.Contact;
import project.project5.repository.ContactRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    //문의글 등록
    public Long join(Contact contact){
        contactRepository.save(contact);
        return contact.getId();
    }

    //문의글 리스트 조회
    public List<Contact> selectContact(){
        return contactRepository.findAll();
    }
}
