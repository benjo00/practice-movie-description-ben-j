package org.example;

import org.example.models.Movie;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    private List<Movie> movies = new ArrayList<>();
    private Client client = new Client();

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("movies", movies);
        return "form";
    }

    @PostMapping("/generate")
    public String generateDescription(@RequestParam String title) {
        String prompt = "Describe the movie '" + title + "' concisely.";
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.0-flash-001",
                prompt,
                null
        );
        String description = response.text();
        movies.add(new Movie(title, description));
        return "redirect:/";
    }
}
