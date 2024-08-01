package com.group.libraryapp.domain.user

interface UserRepositoryCustom {

    fun customFindAllWithHistories() : List<User>
}