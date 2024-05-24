package db.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.model.IBean;
import db.model.ItemDeleteBean;
import db.model.ItemDeleteExecBean;
import db.model.ItemInsertBean;
import db.model.ItemInsertExecBean;
import db.model.ItemListBean;
import db.model.ItemUpdateBean;
import db.model.ItemUpdateExecBean;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/control")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//リクエスト・パラメータを取得
		String action = request.getParameter("action");
		
		String page = "/db/error.jsp";

		IBean bean = null;

		try {
			if (action == null || action.equals("list")) {
				bean = new ItemListBean();
			} else if (action.equals("insert")) {
				bean = new ItemInsertBean();
			} else if (action.equals("insert_exec")) {
				bean = new ItemInsertExecBean();
			} else if (action.equals("update")) {
				bean = new ItemUpdateBean();
			} else if (action.equals("update_exec")) {
				bean = new ItemUpdateExecBean();
			} else if (action.equals("delete")) {
				bean = new ItemDeleteBean();
			} else if (action.equals("delete_exec")) {
				bean = new ItemDeleteExecBean();
			}

			if (bean != null) {
				page = bean.execute(request);
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}

		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
