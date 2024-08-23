package com.example.Project2.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.YearMonth;
public class CurrentYearValidator implements ConstraintValidator<CurrentYear, Integer> {
        @Override
        public boolean isValid(Integer value, ConstraintValidatorContext context) {
            return value <= YearMonth.now().getYear();
        }


}
