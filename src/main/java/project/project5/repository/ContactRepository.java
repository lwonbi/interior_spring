package project.project5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project5.domain.Contact;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
