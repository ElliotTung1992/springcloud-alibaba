package com.github.elliot.gatewaycenter.controller;

import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
@RequestMapping("/user/")
public class UserController {

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(ServerWebExchange exchange, String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            SaResult res = SaReactorSyncHolder.setContext(exchange, ()->{
                StpUtil.login(10001);
                return SaResult.data(StpUtil.getTokenInfo());
            });

            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public SaResult isLogin(ServerWebExchange exchange) {
        SaResult res = SaReactorSyncHolder.setContext(exchange, ()->{
            System.out.println("是否登录：" + StpUtil.isLogin());
            return SaResult.data(StpUtil.getTokenInfo());
        });
        return SaResult.data(res);
    }

}

