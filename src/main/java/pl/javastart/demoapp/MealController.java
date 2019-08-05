package pl.javastart.demoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
public class MealController {

    private MealRepository mealRepository;

    public MealController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping("/edytuj")
    public String editForm(@RequestParam Long id, Model model) {

        Optional<Meal> mealOptional = mealRepository.findById(id);

        if(mealOptional.isPresent()) {
            Meal meal = mealOptional.get();
            model.addAttribute("meal", meal);
            model.addAttribute("types", MealType.values());
            return "edit";
        } else {
            return "redirect:/";
        }

    }

    @PostMapping("/edit")
    public String edit(Meal meal) {
        mealRepository.save(meal);
        return "redirect:/";
    }

    @GetMapping("/usun")
    public String delete(@RequestParam Long id) {
        mealRepository.deleteById(id);
        return "redirect:/";
    }
}
