package com.sprintboot.study.repositories

import com.sprintboot.study.domain.Notice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoticeRepository:JpaRepository<Notice, Long> {
}