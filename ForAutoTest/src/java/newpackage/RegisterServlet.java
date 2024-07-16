package newpackage;

import java.io.IOException;
import java.util.regex.Pattern;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fullName = request.getParameter("full_name");
        String gender = request.getParameter("gender");
        String[] hobbiesArray = request.getParameterValues("hobbies");
        String hobbies = String.join(", ", hobbiesArray != null ? hobbiesArray : new String[0]);
        String job = request.getParameter("job");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");

        boolean hasError = false;
        StringBuilder errorMessage = new StringBuilder();

        if (fullName == null || fullName.trim().isEmpty()) {
            hasError = true;
            errorMessage.append("Full Name is required.<br>");
        }

        if (username == null || username.trim().isEmpty()) {
            hasError = true;
            errorMessage.append("Username is required.<br>");
        }

        if (password == null || password.length() <= 6) {
            hasError = true;
            errorMessage.append("Password must be more than 6 characters.<br>");
        }

        if (gender == null) {
            hasError = true;
            errorMessage.append("Gender is required.<br>");
        }

        if (hobbiesArray == null || hobbiesArray.length == 0) {
            hasError = true;
            errorMessage.append("At least one hobby must be selected.<br>");
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty() || !phoneNumber.matches("^0\\d+$")) {
            hasError = true;
            errorMessage.append("Phone number is required and must start with 0.<br>");
        }

        Pattern emailPattern = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        if (email == null || !emailPattern.matcher(email).matches()) {
            hasError = true;
            errorMessage.append("Invalid email format.<br>");
        }

        HttpSession session = request.getSession();
        if (hasError) {
            session.setAttribute("errorMessage", errorMessage.toString());
            session.setAttribute("fullName", fullName);
            session.setAttribute("gender", gender);
            session.setAttribute("hobbies", hobbiesArray);
            session.setAttribute("job", job);
            session.setAttribute("username", username);
            session.setAttribute("email", email);
            session.setAttribute("phoneNumber", phoneNumber);
            response.sendRedirect("register.jsp");
        } else {
            UserDAO userDAO = new UserDAO();
            try {
                userDAO.insertUser(fullName, gender, hobbies, job, username, password, email, phoneNumber);
                session.removeAttribute("errorMessage");
                response.sendRedirect("success.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("errorMessage", "Database error: " + ex.getMessage());
                response.sendRedirect("register.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
