package pl.haladyj.springsecurity9.security.csrf;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//implementing custom token repo and generator
public class CustomCsrfTokenRepository implements CsrfTokenRepository {

    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        CsrfToken csrfToken = new DefaultCsrfToken(
                "X-CSRF-TOKEN",
                "_csrf",
                "123456789" //just for purpose of this example and easy testing, NEVER IN REAL SCENARIO
        );
        return csrfToken;
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    @Override
    public CsrfToken loadToken(HttpServletRequest httpServletRequest) {
        return null;
    }
}
