package u3f.rs.spring_sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sampleController {
    @GetMapping("/")
    public String sampleGet(){
        return "hello";
    }

}
