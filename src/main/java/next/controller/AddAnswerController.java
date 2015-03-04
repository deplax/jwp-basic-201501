package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class AddAnswerController extends AbstractController {
	
	AnswerDao answerDao = AnswerDao.getInstance();
	QuestionDao questionDao = QuestionDao.getInstance();
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		long questionId = Long.parseLong(request.getParameter("questionId"));
		answerDao.insert(new Answer(writer, contents, questionId));
		questionDao.countOfComment(questionId);

		return jsonView();
	}
}
