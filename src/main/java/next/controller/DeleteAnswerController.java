package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class DeleteAnswerController extends AbstractController {
	AnswerDao answerDao = AnswerDao.getInstance();
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long answerId = Long.parseLong(request.getParameter("answerId"));
		answerDao.delete(answerId);

		return jsonView();
	}
}
