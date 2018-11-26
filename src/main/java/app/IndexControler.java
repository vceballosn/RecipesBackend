package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;;

@Controller
public class IndexControler {
    @RequestMapping("/webapp/html")
	public String getIndexPage(){
		return "";
	}
	
}
