package com.example.Project2.integration;
import com.example.Project2.validators.CurrentYear;
import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Book {
    private int id;
    private Integer person_id;

    @NotNull(message = "Название книги не может быть пустым")
    @Pattern(regexp = "[0-9А-ЯЁ][0-9a-zA-Zа-яА-ЯёЁ\\-\\s]+",
            message = "Должен быть формат \"Название\" на русском языке")
    private String title;

    @NotNull(message = "Фамилия и имя автор не могут быть пустыми")
    @Pattern(regexp = "[А-ЯЁ][а-яА-ЯёЁ\\-]+\\s[А-ЯЁ][а-яА-ЯёЁ\\-]+",
            message = "Должен быть формат \"Фамилия Имя\" на русском языке")
    private String author;

    @Min(value = 1445, message = "Год издания должен быть больше 1445")
    @CurrentYear
    private int year;
}