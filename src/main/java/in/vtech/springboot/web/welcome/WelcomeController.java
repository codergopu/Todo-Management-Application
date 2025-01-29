package in.vtech.springboot.web.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	// GET REQUEST
		// http://localhost:8081/login
			@RequestMapping(value = "/", method = RequestMethod.GET)
			public String gotoWelcomePage(ModelMap model) {
				String username = getLogggedInUserName();
				model.put("name",username);
				return "welcome";
			}
			private String getLogggedInUserName() {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				return authentication.getName();
			}
}
