# 박찬진, 이도호, 정원철

셋이서 같이 풀었습니다.

1번
---
commit 함.

2번
---
1. core.mvc.DispatcherServlet.service에서 @WebServlet(name="dispatcher", urlPatterns="*.next")를 통해 Servlet Container가 초기화 된다.

3번
--
1. web.xml
2. index.jsp
3. response.sendRedirect("/list.next")
4. sevlet 컨테이너가 core.mvc.DispatcherServlet.service 실행 (어노테이션 @WebServlet(name="dispatcher", urlPatterns="*.next"))
5. rm.findcontroller 가 core.mvc.RequestMapping 에서 mappings.put("/list.next", new ListController());  ListController() 실행
6. next.controller.ListController 에서 questionDao.findAll(); 를 jstlView("list.jsp"); 랑 mav.addObject로 합쳐가지고 리턴(model and view)
7. core.mvc.DispatcherServlet.service 가 리턴된 mav의 excute메쏘드를 실행한후에 getView 해서 render().

10번
--
- private List<Answer> answers;와 private List<Question> questions; 이 인스턴스가 생성되고 계속해서 공유하게 된다. 이렇게 되면, 동시에 리스트에 접속할 경우 문제가 발생하게 되므로 각각의 메소드 안에 넣어 충돌이 없도록 해야 한다.