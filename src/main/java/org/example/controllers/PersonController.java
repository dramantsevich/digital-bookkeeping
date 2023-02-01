package org.example.controllers;

import org.example.daos.PersonDAO;
import org.example.models.Person;
import org.example.utils.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDAO personDAO;
    private final PersonValidator personValidator;
    private static final String REDIRECT_PERSON = "redirect:/person";

    @Autowired
    public PersonController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }

    @GetMapping
    public String getPersonListPage(Model model) {
        model.addAttribute("personList", personDAO.getPersonList());

        return "person/index";
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPersonById(id));

        return "person/person";
    }

    @GetMapping("/new")
    public String getNewPersonPage(@ModelAttribute("person") Person person) {
        return"person/new";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors()) {
            return "person/new";
        } else {
            personDAO.save(person);

            return REDIRECT_PERSON;
        }
    }
}
