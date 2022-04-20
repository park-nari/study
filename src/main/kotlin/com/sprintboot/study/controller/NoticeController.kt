package com.sprintboot.study.controller

import com.sprintboot.study.domain.Notice
import com.sprintboot.study.repositories.NoticeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value = ["/notice"])
class NoticeController {

    @Autowired
    private lateinit var noticeRepository: NoticeRepository

    @GetMapping(value = ["/"])
    fun list(
        model: Model
    ): String{

        val noticeList:List<Notice> = noticeRepository.findAll()
        model.addAttribute("noticeList", noticeList)

        return "page/notice/noticeList"
    }

    @RequestMapping(value = ["/content", "/content/{id}"], method = [RequestMethod.GET])
    fun content(
        @PathVariable("id") id: Long?,
        model: Model
    ): String{

        return "page/notice/noticeContent"
    }

    @GetMapping(value = ["/form"])
    fun form(
        @RequestParam
        id:Long?,
        model: Model
    ): String{

        var notice: Notice = if(id != null){
            noticeRepository.getById(id)
        } else{
            Notice(null, null, null)
        }
        model.addAttribute("notice", notice)
        return "page/notice/noticeForm"
    }

    @PostMapping(value = ["/form"])
    fun addForm(
        notice:Notice,
        model: Model
    ): String{

        noticeRepository.save(notice)
        var noticeList: List<Notice>? = noticeRepository.findAll()
        model.addAttribute("noticeList", noticeList)

        return "page/notice/noticeList"
    }
}