package db.model;

import javax.servlet.http.HttpServletRequest;

import db.dao.DAOException;
import db.dao.ItemDAO;

public class ItemInsertExecBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			//リクエスト・パラメータを取得
			int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			//ItemDAOのインスタンスを生成
			ItemDAO dao = new ItemDAO();
			
			boolean check = dao.insert(categoryCode, name, price);
			
			if (check == false) {
				throw new DAOException("登録に失敗しました。");
			}
	
			return "/control?action=list";
			
//			List<Item> list = dao.findAll();
//			
//			//リクエストスコープに記憶させる
//			request.setAttribute("list", list);
//			
//			return "/db/user_list.jsp"; //表示するページを返す
		} catch (NumberFormatException e) {
			throw new DAOException("整数に変換できません。");
		}
	}

}
