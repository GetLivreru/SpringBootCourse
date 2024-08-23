package com.example.Project2.integration;

import com.example.Project2.validators.CurrentYear;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Setter
@Getter
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