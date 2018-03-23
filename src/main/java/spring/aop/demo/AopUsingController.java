package spring.aop.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JadenOliver on 2018/3/23.
 */
@Controller
@RequestMapping("notify")
public class AopUsingController {

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    @ResponseBody
    public String payResultAdvise(HttpServletRequest request, HttpServletResponse response){
        String orderNo = request.getParameter("orderNo");

        System.out.println("进入异步回调方法之中，参数orderNo的值为：" + orderNo);

        return "success";
    }
}
