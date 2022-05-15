package com.sprintboot.study.usecase

import com.sprintboot.study.domain.Notice
import com.sprintboot.study.repositories.NoticeRepository

class NoticeUsecase(
    private val noticeRepository: NoticeRepository
): NoticeUsecaseImpl {

    override fun getNoticeAll(): List<Notice> {
        return noticeRepository.findAll()
    }
}