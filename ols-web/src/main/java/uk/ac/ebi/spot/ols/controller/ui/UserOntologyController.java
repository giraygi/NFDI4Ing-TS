package uk.ac.ebi.spot.ols.controller.ui;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.ac.ebi.spot.ols.entities.UserOntology;
import uk.ac.ebi.spot.ols.repositories.UserOntologyRepository;

@Controller
@RequestMapping("/user")
public class UserOntologyController {
    
    private final UserOntologyRepository userOntologyRepository;

    @Autowired
    public UserOntologyController(UserOntologyRepository userOntologyRepository) {
        this.userOntologyRepository = userOntologyRepository;
    }
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String showUserList(Model model) {
        model.addAttribute("userontologies", userOntologyRepository.findAll());
        return "user/list";
    }
    @RequestMapping(value="/emptylist", method = RequestMethod.GET)
    public String showEmptyListForm(UserOntology userOntology, Model model) {
    	model.addAttribute("userontology", new UserOntology());
        return "user/add-ontology";
    }
    
    
    @RequestMapping(value="/add-ontology", method = RequestMethod.POST)
    public String addUserOntology(@Valid UserOntology userOntology, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add-ontology";
        }
        
        userOntologyRepository.save(userOntology);
        return "redirect:/user/list";
    }
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        UserOntology userOntology = userOntologyRepository.findOne(id);
        model.addAttribute("userontology", userOntology);
        
        return "user/update-ontology";
    }
    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, @Valid UserOntology userOntology, BindingResult result, Model model) {
        if (result.hasErrors()) {
            userOntology.setId(id);
            return "user/update-ontology";
        }
        
        userOntologyRepository.save(userOntology);

        return "redirect:/user/list";
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id, Model model) {
        UserOntology userOntology = userOntologyRepository.findOne(id);
        userOntologyRepository.delete(userOntology);
        
        return "redirect:/user/list";
    }
}
