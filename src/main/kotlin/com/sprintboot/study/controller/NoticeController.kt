package com.sprintboot.study.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/notice")
class NoticeController {

    fun list(): String{

        return "/list"
    }
}