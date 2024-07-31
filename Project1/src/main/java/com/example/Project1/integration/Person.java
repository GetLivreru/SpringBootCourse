package com.example.Project1.integration;

import com.example.Project1.validators.CurrentYear;
import lombok.*;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import jakarta.validation.constraints.*;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Person {
    private int id;

    @NotNull(message = "ФИО не может быть пустым")
    @Pattern(regexp = "([А-ЯЁ][а-яА-ЯёЁ\\-]+\\s){2}[А-ЯЁ][а-яё]+",
            message = "Должен быть формат \"Фамилия Имя Отчество\" на русском языке")
    private String name;

    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    @CurrentYear
    private int year;
}