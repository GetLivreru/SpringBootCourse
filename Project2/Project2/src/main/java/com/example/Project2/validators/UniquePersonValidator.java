package com.example.Project2.validators;


import com.example.Project2.dao.PersonDAO;
import com.example.Project2.integration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniquePersonValidator implements Validator {
    private final PersonDAO personDAO;



    @Autowired
    public UniquePersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public boolean supports(Class<?> clazz){
        return Person.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object object, Errors errors) {
        Person person = (Person) object;
        Person personInBase = personDAO.showPerson(person.getName());
        if (personInBase != null && person.getId() != personInBase.getId()) {
            errors.rejectValue("name", "", "Читатель с таким ФИО уже существует");
        }
    }
}
