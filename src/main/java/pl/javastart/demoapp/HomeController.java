package pl.javastart.demoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private MealRepository mealRepository;

    public HomeController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Meal> meals = mealRepository.findAll();
        model.addAttribute("meals", meals);
        return "home";
    }
}
