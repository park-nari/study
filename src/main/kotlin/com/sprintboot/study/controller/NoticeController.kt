package com.sprintboot.study.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value = ["/notice"])
class NoticeController {

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun list(): String{

        return "page/notice/noticeList"
    }

    @RequestMapping(value = ["/content", "/content/{id}"], method = [RequestMethod.GET])
    fun content(
        @PathVariable("id") id: Long?,
        model: Model
    ): String{

        return "page/notice/noticeContent"
    }
}