package com.example.bingo.controller;


import com.example.bingo.core.conditions.query.QueryWrapper;
import com.example.bingo.dao.FunctionDao;
import com.example.bingo.entity.CpfFunction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * Test Controller
 * </pre>
 *
 * @author maozhi.lan@meicloud.com
 * @version 1.00.00
 * <p>
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Resource
    private FunctionDao functionDao;

    @GetMapping("/echo")
    @ResponseStatus(HttpStatus.OK)
    public String echo() {
        List<CpfFunction> cpfFunctions = functionDao.selectList(new QueryWrapper<>());
        for (CpfFunction cpfFunction : cpfFunctions) {
            System.out.println(cpfFunction.getFunctionName());
        }
        return "bingo!";
    }


}
