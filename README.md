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