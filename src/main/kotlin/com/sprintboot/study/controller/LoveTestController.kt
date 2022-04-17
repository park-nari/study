package com.sprintboot.study.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/loveTest")
class LoveTestController {

    @RequestMapping("/")
    fun top(model: Model): String{
        model.addAttribute("page", "top")
        return "page/loveTest/loveTest"
    }

    @RequestMapping("/question")
    fun question(model: Model): String{
        model.addAttribute("page", "question")
        return "page/loveTest/loveTest"
    }

    @RequestMapping("/selection")
    fun select(model: Model): String{
        model.addAttribute("page", "selection")
        return "page/loveTest/loveTest"
    }

    @RequestMapping("/result")
    fun result(model: Model): String{
        model.addAttribute("page", "result")
        return "page/loveTest/loveTest"
    }
}