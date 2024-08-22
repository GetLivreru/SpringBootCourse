package com.example.Project1.controller;


import com.example.Project1.dao.PersonDAO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
    class PeopleControllerTest {
    private MockMvc mockMvc;

    @Mock
    private PersonDAO personDAO;

}
