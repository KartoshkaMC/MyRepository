package com.userlist.controller;

import com.userlist.dao.UserDao;
import com.userlist.model.*;
import org.springframework.stereotype.Controller;
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
    public String signIn(@RequestParam String name, @RequestParam String password) throws SQLException, ClassNotFoundException
    {
        if(userDao.signInUser(name, password))
        {
            return "redirect:/users";
        }
        return "index";
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public ModelAndView listUser() throws SQLException, ClassNotFoundException
    {
        List<User> list = userDao.listUsers();
        ModelAndView map = new ModelAndView("users");
        map.addObject("users", list);
        return map;
    }

    @RequestMapping(value="users/del/{id}", method = RequestMethod.GET)
    public ModelAndView delUser(@PathVariable Integer id) throws SQLException, ClassNotFoundException {
        userDao.removeUser(id);
        return listUser();
    }

    @RequestMapping(value = "users/add/", method = RequestMethod.POST)
    public ModelAndView newUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password) throws SQLException, ClassNotFoundException {
        userDao.addUser(name, surname, password);
        return listUser();
    }
}