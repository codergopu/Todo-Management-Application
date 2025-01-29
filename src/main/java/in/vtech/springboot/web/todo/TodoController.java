package in.vtech.springboot.web.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// http://localhost:8081/list-todos => listTodos.jsp
//	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
//	public String gotoListTodosPage() {
//		return "listTodos1";
//	}

	// http://localhost:8081/list-todos => listTodos.jsp
//		@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
//		public String gotoListTodosPage() {
//			return "listTodos2";
//		}

	// http://localhost:8081/list-todos => listTodos.jsp
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String gotoListTodosPage(ModelMap model) {
		String username=getLogggedInUserName();
		List<Todo> todos = todoService.findByUsername(username);
		model.put("todos", todos);

		return "listTodos";
	}

	// http://localhost:8081/add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		//String username = (String) model.get("name");
		String username = getLogggedInUserName();
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	// http://localhost:8081/add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLogggedInUserName();
		todo.setUsername(username);		
		todoService.addTodo(todo);
		
		return "redirect:list-todos";
	}
	
	// http://localhost:8081/delete-todo
	
	@RequestMapping(value="delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		//delete todo
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	// http://localhost:8081/update-todo
		@RequestMapping(value = "update-todo", method = RequestMethod.GET)
		public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
			//String username = (String) model.get("name");
			String username = getLogggedInUserName();
//			Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);/
			Todo todo=this.todoService.findById(id);
			model.addAttribute("todo", todo);
			return "todo";
		//	
		}
		
		// http://localhost:8081/update-todo
		@RequestMapping(value = "update-todo", method = RequestMethod.POST)
		public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
			
			if(result.hasErrors()) {
				return "todo";
			}
			//String username = (String) model.get("name");
			String username = getLogggedInUserName();
			todo.setUsername(username);
			todoService.updateTodo(todo);
			
			return "redirect:list-todos";
		}
		
		private String getLogggedInUserName() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
		}
	
}
