package customerservice.controller;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/rest/user")
@RestController
public class RestControllerUser {
    private static final String REST_URL_PREFIX = "";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/find/{id}")
    public User restfindUserById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://localhost:8080/user/find/{id}", User.class, id);
    }
    @GetMapping("/findAll")
    public List<User> restfindUserById(){
        return restTemplate.getForObject("http://localhost:8080/user/findAll",List.class);
    }
}