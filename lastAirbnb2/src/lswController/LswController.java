package lswController;

	import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import esAction.ClickLikeInTimelineAction;
import esAction.DeleteNotificationAction;
import esAction.DoFollowAction;
import esAction.DoUnfollowAction;
import esAction.InsertReplyAction;
import esAction.JoinAction;
import esAction.LoginAction;
import esAction.LogoutAction;
import esAction.ShowNextTimelinePageAction;
import esAction.UpdateAddressAction;
import esAction.UpdateEmailAction;
import esAction.UpdateNameAction;
import esAction.UpdatePhoneNumAction;
import esAction.UpdateSecondNumAction;
import myAction.main2Action;
import myAction.main3Action;
import swAction.CollectionAction;
import swAction.ExpInfoAction;
import swAction.PaymentAction;
import swAction.WriteReviewAction;



	@WebServlet("/LswController")
	public class LswController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String command = request.getParameter("command");
			if(command == null)
				command = "element"; 	
			Action action = null;
			switch(command) {
			case "element" : action = new main2Action(); break;
			case "logout" : action = new LogoutAction(); break;
			case "login" : action = new LoginAction(); break;
			case "join" : action = new JoinAction(); break;
			case "updateName" : action = new UpdateNameAction(); break;
			case "updateEmail" : action = new UpdateEmailAction(); break;
			case "updatePhoneNum" : action = new UpdatePhoneNumAction(); break;
			case "updateAddress" : action = new UpdateAddressAction(); break;
			case "updateSecondNum" : action = new UpdateSecondNumAction(); break;
			case "deleteNotification" : action = new DeleteNotificationAction(); break;
			case "clickLike" : action = new ClickLikeInTimelineAction(); break;
			case "insertReply" : action = new InsertReplyAction(); break;
			case "unfollowing" : action = new DoUnfollowAction(); break;
			case "following" : action = new DoFollowAction(); break;
			case "showNextTimeline" : action = new ShowNextTimelinePageAction(); break;
			case "main2" : action = new main2Action(); break;
		    case "main3" : action = new main3Action(); break;
		    case "write_review" : action = new WriteReviewAction(); break;
		    
		    case "expInfo" : action = new ExpInfoAction(); break;
		    case "collection" : action = new CollectionAction(); break;
		    case "payment" : action = new PaymentAction(); break;
			}
			action.execute(request, response); 
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}

