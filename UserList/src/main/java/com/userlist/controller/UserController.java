package com.userlist.controller;

import com.userlist.dao.UserDao;
import com.userlist.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController
{
    UserDao userDao = new UserDao();

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String startPage() throws SQLException, ClassNotFoundException
    {
        return "index";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signIn(Model model, @RequestParam String name, @RequestParam String password) throws SQLException, ClassNotFoundException
    {
        String role = userDao.signInUser(name, password);
        if(role.equals("none"))
        {
            model.addAttribute("message", "Uncorrect login or password");
        }
        ModelAndView map = new ModelAndView("index");

        if(role.equals("admin") || role.equals("user"))
        {
            return account(name, role);
        }
        return map;
    }

    @RequestMapping(value = "/signin/add/{id}", method = RequestMethod.GET)
    public ModelAndView addAuto (@PathVariable Integer id) throws SQLException, ClassNotFoundException
    {
        ModelAndView map = new ModelAndView("/signin");
        userDao.addCar(id);
        return map;
    }

    @RequestMapping(value = "/signin/del/{id}", method = RequestMethod.GET)
    public ModelAndView removeAuto (@PathVariable Integer id) throws SQLException, ClassNotFoundException
    {
        ModelAndView map = new ModelAndView("/signin");
        userDao.removeCar(id);
        return map;
    }

    public ModelAndView account(String name, String role) throws SQLException, ClassNotFoundException
    {
        ModelAndView map = new ModelAndView("/account");
        if(role.equals("admin"))
        {
            map.addObject("link", "users");
            //getUsers();
        }
        map.addObject("cars", userDao.getAuto(name));
        map.addObject("allcars",userDao.getAllAuto());
        return map;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers () throws SQLException, ClassNotFoundException
    {
        ModelAndView map = new ModelAndView("users");
        List<User> list = userDao.listUsers();
        map.addObject("users", list);

        return map;
    }

    @RequestMapping(value="users/del/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable Integer id) throws SQLException, ClassNotFoundException {
        userDao.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String newUser(Model model, @RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String description) throws SQLException, ClassNotFoundException
    {
        boolean foo = userDao.addUser(name, surname, password, description, 1);
        if(!foo)
        {
            model.addAttribute("message", "A person with this name already exists!");
        }
        return "signup";
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String signUp () throws SQLException, ClassNotFoundException
    {
        return "signup";
    }
}