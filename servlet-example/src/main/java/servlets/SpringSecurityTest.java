package servlets;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 8/28/13
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpringSecurityTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        resp.getWriter().write("Hello, " + user.getUsername() + "!");
    }
}
