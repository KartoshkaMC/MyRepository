package com.userlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController
{
    public class UserClass
    {
        private Integer id;
        private String name;
        String surname;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public UserClass (Integer id, String name, String surname)
        {
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

    }

    private List<UserClass> list = getList();

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView listUser()
    {
        ModelAndView map = new ModelAndView("users");
        map.addObject("users", list);
        return map;
    }

    private List<UserClass> getList()
    {
        List<UserClass> list = new ArrayList<>();
        list.add(new UserClass(1, "HHH", "VVV"));
        list.add(new UserClass(2, "ttt", "dfgdfg"));
        list.add(new UserClass(3, "zxcv", "ryiuo"));
        list.add(new UserClass(4, "vbm", "yiouo"));
        list.add(new UserClass(5, "qwerqwr", "dfghdfh"));
        list.add(new UserClass(6, "afsadf", "dfhdfgh"));

        return list;
    }

    @RequestMapping(value="/del/{id}", method = RequestMethod.GET)
    public ModelAndView delUser(@PathVariable Integer id)
    {
        for(UserClass u : list)
        {
            if(u.id.equals(id))
            {
                list.remove(u);
                return listUser();
            }
        }
        return listUser();
    }
}