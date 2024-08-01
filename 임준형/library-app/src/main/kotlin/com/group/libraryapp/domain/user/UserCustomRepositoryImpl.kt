package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.loanhistory.QUserLoanHistory.userLoanHistory
import com.group.libraryapp.domain.user.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory

class UserCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : UserRepositoryCustom {

    override fun findAllWithHistories(): List<User> {
        return queryFactory
            .select(user)
            .distinct()
            .from(user)
            .leftJoin(user, userLoanHistory.user).fetchJoin()
            .fetch()
    }
}