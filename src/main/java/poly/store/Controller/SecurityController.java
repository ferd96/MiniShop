package poly.store.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    
    @RequestMapping("/security/login/form")
	public String form() {
		return "security/login";
	}
	@RequestMapping("/security/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "product/list";
	}
	@RequestMapping("/security/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
	}
	@RequestMapping("/security/logoff/success")
	public String logoff(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
	@RequestMapping("/security/unauthoried")
	public String denied(Model model) {
		model.addAttribute("message", "Bạn không có quyền truy xuất");
		return "security/login";
	}
	
	// @RequestMapping("/osecurity2/login/success")
	// public String success(Osecurity2securityenticationToken osecurity2) {
	// 	userService.loginFromOsecurity2(osecurity2);
	// 	return "forward:/security/login/success";
	// }
}