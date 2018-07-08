package crm_01.dao.aspect;

import org.springframework.stereotype.Component;

@Component
public class DaoAspect {

    public void before(){
        System.out.println("before。。。");
    }
}
