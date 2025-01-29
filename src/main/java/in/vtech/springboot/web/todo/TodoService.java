package in.vtech.springboot.web.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

//	private static List<Todo> todos = new ArrayList<>();
//
//	private static int todosCount = 0;
//	
//	static {
//		todos.add(new Todo(++todosCount, "vtech", "Get AWS Certified", LocalDate.now().plusYears(1), false));
//		todos.add(new Todo(++todosCount, "vtech", "Learn DevOps", LocalDate.now().plusYears(2), false));
//		todos.add(new Todo(++todosCount, "vtech", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
//	}
//
	public List<Todo> findByUsername(String username) {
		List<Todo> todoList=this.todoRepository.findByUsername(username);
		return todoList;
	} 
		
		private TodoRepository todoRepository;
		public TodoService(TodoRepository todoRepository) {
			this.todoRepository=todoRepository;
		}
		
//		
	
//	
	public void addTodo(@Valid Todo todo) {
		this.todoRepository.save(todo);
//		
	}
//	
	public void deleteById(int id) {
		this.todoRepository.deleteById(id);
//		
//		
	}
//
//	public void updateTodo(@Valid Todo todo) {
//		int id = todo.getId();
//		deleteById(id);
//		todos.add(todo);
//	}

	public Todo findById(int id) {
		Todo todo=this.todoRepository.findById(id).get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		this.todoRepository.save(todo);
	}
	
	
}
