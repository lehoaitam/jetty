package tamle.service;

import org.springframework.stereotype.Service;

@Service("HelloService")
public class HelloServiceImpl implements HelloService {
    public String hello(String name){
        return "hello" + name;
    }
}
