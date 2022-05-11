package com.ead.cinemal.controller;

import com.ead.cinemal.dao.MovieDAO;
import com.ead.cinemal.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class MovieController {

    private MovieDAO movieDAO;

    @Autowired
    public MovieController(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }

    @GetMapping
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("movies", movieDAO.getAllMovies());
        return "navigation/index";
    }

    @GetMapping("/movies")
    public String movies(Model model, HttpServletRequest request){

        model.addAttribute("movies", movieDAO.getAllMovies());

        return "movie/movies";
    }

    @GetMapping("/movies/{id}")
    public String movie(Model model, @PathVariable("id") int id){
        model.addAttribute("movie", movieDAO.getMovieById(id));
        return "movie/movie";
    }

    @GetMapping("/movies/search")
    public String movie(Model model, HttpServletRequest request){
        String pattern = request.getParameter("pattern");
        if(pattern == null){
            return "redirect:/movies";
        }
        model.addAttribute("filteredMovies", movieDAO.getMoviesByWildCard(pattern));

        return "movie/filteredMovie";
    }

    @GetMapping("/news")
    public String news(){
        return "navigation/news";
    }

    @GetMapping("/contact")
    public String contact(){
        return "navigation/contact";
    }

    @GetMapping("/login")
    public String showForm(){
        return "navigation/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();

        if (request.getParameter("username") == null){
            model.addAttribute("errorMsg", "Please, enter your username");
            return showForm();
        }

        if(request.getParameter("username").equals("admin")){
            session.setAttribute("userRole", "admin");
            return "redirect:/movies";
        }

        session.setAttribute("userRole", request.getParameter("username"));
        return "redirect:/movies";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("userRole", null);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        movieDAO.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/new")
    public String newMovieForm(@ModelAttribute("movie")Movie movie){
        return "movie/new";
    }

    @PostMapping("/new")
    public String addNewMovie(@ModelAttribute("movie") Movie movie){
        movie.setImage("/img/dynamicPosters/blank.jpg");
        movieDAO.addNewMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model, @PathVariable("id") int id){
        model.addAttribute("movie", movieDAO.getMovieById(id));
        return "movie/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateMovie(@ModelAttribute("movie") Movie movie, @PathVariable("id") int id){
        movieDAO.update(movie, id);
        return "redirect:/movies";
    }

}
