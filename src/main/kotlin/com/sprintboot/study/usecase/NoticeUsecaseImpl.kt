package com.sprintboot.study.usecase

import com.sprintboot.study.domain.Notice
import com.sprintboot.study.repositories.NoticeRepository

interface NoticeUsecaseImpl {
    fun getNoticeAll(): List<Notice>
}