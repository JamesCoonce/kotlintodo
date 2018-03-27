package com.example.kotlintodo.core

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long?

    init {
        id = null
    }
}
