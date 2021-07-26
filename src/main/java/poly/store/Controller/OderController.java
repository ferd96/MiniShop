package poly.store.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.seriver.OrderSerive;

@Controller
public class OderController {
	@Autowired
	OrderSerive orderSerive;
	  @RequestMapping("/order/checkout")
      public String Checkout() {
      	return "order/checkout";
      }
	  @RequestMapping("/order/list")
      public String list(Model model,HttpServletRequest request) {
		  String username = request.getRemoteUser();
		  model.addAttribute("orders",orderSerive.findByUsername(username));
      	return "order/list";
      }
	  @RequestMapping("/order/detail/{id}")
      public String detail(@PathVariable("id") Long id, Model model) {
		  model.addAttribute("order",orderSerive.findById(id));
		  
      	return "order/detail";
      }
}

 