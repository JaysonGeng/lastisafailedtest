package Servlet;

import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RagLet extends HttpServlet {

    private static final long serialVersionUID = 369840050351775312L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ���տͻ�����Ϣ
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        String password = request.getParameter("password");
        System.out.println(username + "--" + password);

        // �½��������
        Service serv = new Service();

        // ��֤����
        boolean loged = serv.register(username, password);
        if (loged) {
            System.out.print("Succss");
            request.getSession().setAttribute("username", username);
            // response.sendRedirect("welcome.jsp");
        } else {
            System.out.print("Failed");
        }

        // ������Ϣ���ͻ���
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("�û�����" + username);
        out.print("���룺" + password);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
