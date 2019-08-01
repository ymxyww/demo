package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {

        try {
            if (e instanceof BusinessException) {
                BusinessException businessException = (BusinessException) e;
                Map map = new HashMap();
                map.put("errorCode", 100);
                map.put("errorMag", businessException.getMessage());
                map.put("errorMag2", "");
                map.put("errorMag3", null);
                res.setContentType("application/json;charset=UTF-8");
                res.getWriter().println(JSONObject.toJSONString(map));
            }
        } catch (Exception e2) {

        }

        return null;
    }
}
