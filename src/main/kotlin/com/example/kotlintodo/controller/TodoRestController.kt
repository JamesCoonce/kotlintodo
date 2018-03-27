package com.example.kotlintodo.controller

import com.example.kotlintodo.todo.Todo
import com.example.kotlintodo.todo.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoRestController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @RequestMapping(path = [("/{todoId}")], method = [(RequestMethod.GET)])
    fun getTodo(@PathVariable("todoId") todoId: Long?): Optional<Todo>? {
        return todoRepository.findById(todoId)
    }

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo {
        todoRepository.save(todo)
        return todo
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(todo: Todo) {
        todoRepository.save(todo)
    }

    @RequestMapping(path = [("/{todoId}")], method = [(RequestMethod.DELETE)])
    fun deleteTodo(@PathVariable("todoId") todoId: Long?) {
        todoRepository.deleteById(todoId)
    }
}
