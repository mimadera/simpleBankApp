import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/login")
public class Login extends HttpServlet {

    private int id = 123;
    private String password = "123";
    private int accountBalance = 3812;




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String receivedPassword = req.getParameter("passsword");
        int receivedId = Integer.parseInt(req.getParameter("id"));

        if (receivedPassword.equals(password) && receivedId == id){

            req.setAttribute("id", id);
            req.setAttribute("accountBalance", accountBalance);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("bankAccount.jsp");

            requestDispatcher.forward(req, resp);

        } else {

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");

            requestDispatcher.forward(req, resp);

        }



    }
}
