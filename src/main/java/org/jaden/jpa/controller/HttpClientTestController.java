package org.jaden.jpa.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

//图书控制器
@Controller
@RequestMapping("httpclient")
public class HttpClientTestController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpClientTestController.class);

    @RequestMapping(value = "/testStringParams", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testStringReqParams(HttpServletRequest request){

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String stringReqParams = getReqeustData(request);

        return stringReqParams;

    }//end method


    @RequestMapping(value = "/testKeyValueParams")   //, produces = "application/json;charset=UTF-8"
    @ResponseBody
    public String testKeyValueReqParams(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer sb = new StringBuffer();

        Map reqMap = request.getParameterMap();
        for(Object key:reqMap.keySet()){
            String value = ((String[])reqMap.get(key))[0];
            sb.append(key.toString()).append("---").append(value).append("/n");
        }

        //response.getWriter().write(sb.toString());

        return sb.toString();

    }//end method

    @RequestMapping(value = "/testGetParam", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testGetParam(@RequestParam(value="unionId") String unionId,
                       HttpServletRequest request, HttpServletResponse response) {
        return unionId;
    }


    // 获取request请求报文-------
    // 使用到了：1.适配器模式：Reader(目标对象)---InputSteamReader(适配者)---InputSteam(被适配者)
    //         2.装饰模式：InputSteamReader---BufferedReader(装饰器实现者对象)
    public String getReqeustData(HttpServletRequest request) {
        String data = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));  //, "utf-8"
            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();

            if (StringUtils.isEmpty(data)) {
                return null;
            }

        } catch (Exception e) {
            logger.error("read Inputstream for httpReqeust error", e);
        }
        return data;
    }


}
