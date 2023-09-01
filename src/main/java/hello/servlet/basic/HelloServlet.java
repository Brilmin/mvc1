package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);   //주소창 파라미터값으로 ?username="kim"입력시 아래응답


        response.setContentType("text/plain");  //웹페이지로 답하는것 타입:문자  (헤더에 들어감)
        response.setCharacterEncoding("utf-8"); //인코딩 타입:utf-8           (헤더에 들어감)
        response.getWriter().write("hello " + username);   //http 바디에 다 들어감

    }
}
