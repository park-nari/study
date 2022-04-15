package com.sprintboot.study.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/notice")
class NoticeController {

    @RequestMapping("/list")
    fun list(): String{

        return "page/notice/noticeList"
    }
}