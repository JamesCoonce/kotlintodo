package com.example.kotlintodo.todo

import com.example.kotlintodo.core.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "todo")
class Todo {

    /* GenerationType.IDENTITY is for databases like Postgres
        that use sequence tables instead of auto-increment
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long? = null

    var title: String? = null
    var description: String? = null
    var finished: Boolean? = false


}

