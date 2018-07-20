package com.dongzheng.pasm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @RequestMapping("/no")
    public String no() {
        return "privilege/no";
    }
}
