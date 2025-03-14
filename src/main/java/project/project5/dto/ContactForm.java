package project.project5.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContactForm {
    private Long id;
    @NotEmpty(message = "이름은 필수 항목입니다.")
    private String name;
    @NotEmpty(message = "이메일은 필수 항목입니다.")
    private String email;
    @NotEmpty(message = "문의사항 작성은 필수 항목입니다.")
    private String msg;
    private boolean news;
}
