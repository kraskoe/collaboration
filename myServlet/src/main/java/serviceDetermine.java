import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

/**
 * Class FrontController
 *
 * Created by ykrasko on 23/09/2017.
 */
@WebServlet(urlPatterns = "/resolver")
public class serviceDetermine extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("someText");
        String answer;
        if (text == null) {
            answer = "NULL data";
        } else if (isEmail(text)){
            answer = "This is e-mail";
        } else if (isInsNumber(text)){
            answer = "This is insurance number";
        } else if (isSurname(text)){
            answer = "This is surname";
        } else if (isTelNumber(text)){
            answer = "This is telephone number";
        } else answer = "Data is wrong";
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html><body><p>" + answer + "</p></body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public static boolean isEmail(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z]\\w*@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean isSurname(String s) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean isTelNumber(String s) {
        Pattern pattern = Pattern.compile("(\\+375)(\\d{2})(\\d{3})(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean isInsNumber(String s) {
        Pattern pattern = Pattern.compile("\\d{7}[A-Z]\\d{3}[A-Z]{2}\\d");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
