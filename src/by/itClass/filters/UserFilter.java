package by.itClass.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.itClass.constants.Constants;
import by.itClass.model.entities.User;


@WebFilter("/conConf")
public class UserFilter implements Filter {

    public UserFilter() {
        
    }

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("USER FILTER");
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(Constants.USER);
		
		if(user == null) {
			session.invalidate();
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(request.getServletContext().getContextPath() + Constants.LOGIN_JSP);
			return;
		}
				
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
