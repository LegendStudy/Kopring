package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.loanhistory.QUserLoanHistory.userLoanHistory
import com.group.libraryapp.domain.user.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : UserRepositoryCustom {

    override fun customFindAllWithHistories(): List<User> {
        return queryFactory
            .select(user)
            .distinct()
            .from(user)
            .leftJoin(user.userLoanHistories, userLoanHistory).fetchJoin()
            .fetch()
    }
}