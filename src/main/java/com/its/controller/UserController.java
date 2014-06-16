package com.its.controller;

import com.its.dao.UserDao;
import com.its.model.Users;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexander
 */
@Controller
@RequestMapping("/user")
public final class UserController extends AppController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView view = new ModelAndView("user");
        view.addObject("title", "Users - " + appTitle);

        try {
            List<Users> list = UserDao.list(25, 0);
            view.addObject("users", list);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return view;
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView view = new ModelAndView("user");
        view.addObject("title", "Create User - " + appTitle);
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Users save(@Valid Users user, BindingResult result, final HttpServletRequest request) throws Exception {
        if (result.hasErrors()) {
            user.setMessage(result.getFieldError().getDefaultMessage());
            user.setSuccess(false);
        } else {
            user.setEmail(request.getParameter("email"));
            user.setPassword(getHashPassword(request.getParameter("password")));
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            user.setSuccess(true);
            user.setMessage("User has been created successfully.");
            UserDao.save(user);
        }
        return user;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Users delete(@PathVariable("id") final Integer id, Users user) throws Exception {
        user.setId(id);
        UserDao.delete(user);
        user.setSuccess(true);
        return user;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public @ResponseBody
    Users update(@Valid Users user, BindingResult result, @PathVariable("id") final Integer id, final HttpServletRequest request) throws Exception {
        if (result.hasErrors()) {
            user.setMessage(result.getFieldError().getDefaultMessage());
            user.setSuccess(false);
        } else {
            user.setId(id);
            user.setEmail(request.getParameter("email"));
            user.setPassword(getHashPassword(request.getParameter("password")));
            user.setUpdatedAt(new Date());
            user.setSuccess(true);
            user.setMessage("User has been updated successfully.");
            UserDao.save(user);
        }
        return user;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") final Integer id) {
        ModelAndView view = new ModelAndView("user");
        Users user = UserDao.get(id);
        if (user == null) {
            return new ModelAndView("http/404");
        }
        view.addObject("title", "Edit User - " + appTitle);
        view.addObject("user", user);
        return view;
    }
}
