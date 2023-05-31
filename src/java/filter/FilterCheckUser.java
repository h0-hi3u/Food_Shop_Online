/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ho Trong Hieu
 */
public class FilterCheckUser implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resoure::" + uri);

        HttpSession session = req.getSession(false);

        String userName = null;
        try {
            userName = (String) session.getAttribute("role");
        } catch (Exception ex) {
            userName = null;
        }
        if (userName == null && uri.contains("ViewCart")) {
            this.context.log("Unauthorized access request");
            res.sendRedirect("/SE161557/home/Login");
        } else if (userName == null && uri.contains("Order")) {
            this.context.log("Unauthorized access request");
            res.sendRedirect("/SE161557/home/Login");
        }  else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
