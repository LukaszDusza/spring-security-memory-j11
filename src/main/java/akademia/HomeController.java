package akademia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String homePage() {
    return "index";
  }

  @GetMapping("/user")
  public String userPage() {
    return "user_page";
  }

  @GetMapping("/admin")
  public String adminPage() {
    return "admin_page";
  }


}
