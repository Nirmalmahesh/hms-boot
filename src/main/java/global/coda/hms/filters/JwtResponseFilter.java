package global.coda.hms.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Jwt response filter.
 */
@Component
@Order(2)
public class JwtResponseFilter extends OncePerRequestFilter {


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    HttpServletResponse res = response;
    res.setHeader("name", "nirmal");
    System.out.println("In the Response");
    filterChain.doFilter(request, res);
  }
}
