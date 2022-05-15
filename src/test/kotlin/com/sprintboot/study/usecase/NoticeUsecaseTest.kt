package com.sprintboot.study.usecase

import com.sprintboot.study.domain.Notice
import com.sprintboot.study.repositories.NoticeRepository
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NoticeUsecaseTest {

    val noticeRepository

    constructor(noticeRepository: = NoticeRepository) {
        this.noticeRepository = noticeRepository
    }

    @Test
    fun testName() {

        val noticeUsecase = NoticeUsecase(noticeRepository)
        var actual: List<Notice> = noticeUsecase.getNoticeAll()
        assertThat(actual, null)
    }
}