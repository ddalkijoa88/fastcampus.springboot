package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";
        System.out.println("id : " +id);
        System.out.println("pwd : " +pwd);

        return id+pwd;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMulitParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //json 형태로 리턴받기
        //spring boot에서는 기본적으로 json을 내장하고 있기 때문에 플러그인 등 따로 설치할 필요가 없다
        //파라미터에서 받은 데이터를 json으로 리턴하는 것이 핵심임!
        return searchParam;
    }

}
