package com.sprintboot.study.repositories

import com.sprintboot.study.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//@Dataㅌ
@Repository
interface UserRepository:JpaRepository<User, Long> {
}