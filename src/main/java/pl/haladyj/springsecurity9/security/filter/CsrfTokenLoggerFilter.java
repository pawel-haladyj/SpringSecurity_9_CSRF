package pl.haladyj.springsecurity9.security.filter;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CsrfTokenLoggerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {


        CsrfToken csrfToken = (CsrfToken)request.getAttribute("_csrf"); //attrib name defined in CustomCsrfTokenRepository
        System.out.println(csrfToken.getToken()); //for this tutor purpose only
        chain.doFilter(request,response);
    }
}
