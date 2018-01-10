package controller;


import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserController extends HttpServlet {
    public static final String INSERT_OR_EDIT = "/user.jsp";
    public static final String LIST_USER = "/listUser.jsp";
    private UserDao dao;

    @Override
    public void init() throws ServletException {
        dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(req.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            req.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(req.getParameter("userId"));
            User user = dao.getUserById(userId);
            req.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            req.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstname(req.getParameter("firstName"));
        user.setLastname(req.getParameter("lastName"));

        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        user.setEmail(req.getParameter("email"));
        String userid = req.getParameter("userid");
        if (userid == null || userid.isEmpty()) {
            dao.addUser(user);
        } else {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }

        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
        req.setAttribute("users", dao.getAllUsers());
        view.forward(req, resp);
    }
}
