//package myAction;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import myDao.Main2Dao;
//import myVo.RepresentRoomListVo;
//import myVo.RoomCategoryVo;
//
//@WebServlet("/Main2")
//public class Main2Servlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Main2Dao dao = new Main2Dao();
//	      int cateIdx = 1; // 疫꿸퀡�궚揶쏅�り퐬占쎌젟
//	      try {
//	         cateIdx = Integer.parseInt(request.getParameter("cate"));
//	      } catch(NumberFormatException e) {
//	         e.printStackTrace();
//	      }
////	      System.out.println(cateIdx);'
//	      //燁삳똾�믤�⑥쥓�봺 占쎌뵠�뵳占� 占쎈솁占쎌뵬沃섎챸苑ｆ에占� 獄쏆룄由�
//	       // list1占쎈퓠 燁삳똾�믤�⑥쥓�봺占쎄땀占쎌뒠 占쎈뼖疫뀐옙
//	       ArrayList<RoomCategoryVo> list1 = Main2Dao.getCateAll();
//	       ArrayList<RepresentRoomListVo> roomVo = dao.getRoom(cateIdx);
//	      
//	      
//	      request.setAttribute("list1", list1);
//	      request.setAttribute("cateIdx", cateIdx); 
//	      request.setAttribute("roomVo",roomVo);
//	      RequestDispatcher rd = request.getRequestDispatcher("main2.jsp");
//	      rd.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request,response);
//	}
//
//}
