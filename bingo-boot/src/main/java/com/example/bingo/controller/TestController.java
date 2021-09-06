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
import java.util.Date;
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

    @GetMapping("/selectTwo")
    @ResponseStatus(HttpStatus.OK)
    public String selectTwo() {
        List<CpfFunction> cpfFunctions = functionDao.selectTwo(new QueryWrapper<>());
        for (CpfFunction cpfFunction : cpfFunctions) {
            System.out.println(cpfFunction.getFunctionName());
        }
        return "bingo!";
    }
    @GetMapping("/saveOrUpdate")
    @ResponseStatus(HttpStatus.OK)
    public String saveOrUpdate() {
        CpfFunction cpfFunction = new CpfFunction();
        cpfFunction.setFunctionId(1747L);
        cpfFunction.setFunctionCode("EC_TY_copy2");
        cpfFunction.setFunctionName("通用费用报销单（NEW）_copy2_ff");
        cpfFunction.setFunctionVersion(1);
        cpfFunction.setIsStop("N");
        cpfFunction.setIsDelete("N");
        cpfFunction.setIsPublish("N");
        cpfFunction.setCreationDate(new Date());
        cpfFunction.setCreatedBy(1L);
        functionDao.insertOrUpdate(cpfFunction);

        return "bingo!";
    }


}
