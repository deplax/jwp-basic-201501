package core.mvc;

import java.util.HashMap;
import java.util.Map;

import next.controller.AddAnswerController;
import next.controller.DeleteAnswerController;
import next.controller.DeleteQuestionController;
import next.controller.ListApiController;
import next.controller.ListController;
import next.controller.SaveController;
import next.controller.ShowController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
	private Map<String, Controller> mappings = new HashMap<String, Controller>();
	
	public void initMapping() {
		mappings.put("/list.next", new ListController());
		mappings.put("/show.next", new ShowController());
		mappings.put("/save.next", new SaveController());
		mappings.put("/form.next", new ForwardController("form.jsp"));
		mappings.put("/api/addanswer.next", new AddAnswerController());
		mappings.put("/api/deleteAnswer.next", new DeleteAnswerController());
		mappings.put("/api/list.next", new ListApiController());
		mappings.put("/api/deleteQuestion.next", new DeleteQuestionController());
		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String url) {
		return mappings.get(url);
	}

	void put(String url, Controller controller) {
		mappings.put(url, controller);
	}

}
