package com.example.Project2.integration;

import com.example.Project2.validators.CurrentYear;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id", "books"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "ФИО не может быть пустым")
    @Pattern(regexp = "([А-ЯЁ][а-яА-ЯёЁ\\-]+\\s){2}[А-ЯЁ][а-яё]+",
            message = "Должен быть формат \"Фамилия Имя Отчество\" на русском языке")
    @Column(name = "name")
    private String name;

    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    @CurrentYear
    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "reader")
    private List<Book> books;
}
