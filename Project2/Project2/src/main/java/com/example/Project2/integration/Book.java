package com.example.Project2.integration;

import com.example.Project2.validators.CurrentYear;
import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Entity
@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id", "reader", "takenAt", "isExpired"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person reader;

    @NotNull(message = "Название книги не может быть пустым")
    @Pattern(regexp = "[0-9А-ЯЁ][0-9a-zA-Zа-яА-ЯёЁ\\-\\s]+",
            message = "Должен быть формат \"Название\" на русском языке")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Фамилия и имя автор не могут быть пустыми")
    @Pattern(regexp = "[А-ЯЁ][а-яА-ЯёЁ\\-]+\\s[А-ЯЁ][а-яА-ЯёЁ\\-]+",
            message = "Должен быть формат \"Фамилия Имя\" на русском языке")
    @Column(name = "author")
    private String author;

    @Min(value = 1445, message = "Год издания должен быть больше 1445")
    @CurrentYear
    @Column(name = "year")
    private int year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "taken_at")
    private Date takenAt;

    @Transient
    private boolean isExpired;

    public boolean isExpired() {
        return (new Date().getTime() - takenAt.getTime()) / 86400000 > 10;
    }
}