package com.sprintboot.study.controller

import com.sprintboot.study.domain.Notice
import com.sprintboot.study.repositories.NoticeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value = ["/notice"])
class NoticeController {

    @Autowired
    private lateinit var noticeRepository: NoticeRepository

    @RequestMapping(value = ["/"], method = [RequestMethod.GET, RequestMethod.POST])
    fun list(
        notice: Notice?,
        model: Model
    ): String{

        notice?.id?.let{
            noticeRepository.save(notice)
        }
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

    @RequestMapping(value = ["/form"], method = [RequestMethod.GET, RequestMethod.POST])
    fun form(
        @PathVariable("id") id: Long?,
        model: Model
    ): String{

        return "page/notice/noticeForm"
    }
}