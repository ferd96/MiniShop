package poly.store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import poly.store.entity.Product;
import poly.store.seriver.ProductSerive;


@Controller
public class ProductController {
	@Autowired
	ProductSerive productSerive;
        @RequestMapping("/product/list")
        public String list(Model model ,@RequestParam("cid")Optional<String> cid) {
        	
        	if(cid.isPresent()) {
        		List<Product> list = productSerive.findByCategoryId(cid.get());
        		 model.addAttribute("items",list);
        	}else {
        	  	
               List<Product> list  = productSerive.findAll();
                model.addAttribute("items",list);
			}
      
        	return "product/list";
        }
        @RequestMapping("/product/detail/{id}")
        public String Detail(Model model,@PathVariable("id") Integer id) {
        	Product item = productSerive.findById(id);
        	model.addAttribute("item",item);
        	return "product/detail";
        }
        @RequestMapping("/index")
        public String hi() {
        	return "layout/index";
        }
}
