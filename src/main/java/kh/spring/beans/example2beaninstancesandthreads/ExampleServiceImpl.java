package kh.spring.beans.example2beaninstancesandthreads;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl {

	@Autowired
	private TaskExecutor taskExecutor;
	
// Instead of Autowiring an instance of ExampleRunnable, create a new instance each time
// from the ApplicationContext
//	@Autowired
//	private ExampleRunnable example;

	@Autowired
	private ApplicationContext context;
	
	@PostConstruct
	public void init() {
		for(int i=0; i < 10; i++) {
			ExampleRunnable example = this.context.getBean(ExampleRunnable.class);
			this.taskExecutor.execute(example);
		}
	}
	
}
