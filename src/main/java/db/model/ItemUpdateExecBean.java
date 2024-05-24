package db.model;

import javax.servlet.http.HttpServletRequest;

import db.dao.DAOException;
import db.dao.ItemDAO;

public class ItemUpdateExecBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			//リクエスト・パラメータを取得
			int code = Integer.parseInt(request.getParameter("code"));
			int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			//UserDAOのインスタンスを生成
			ItemDAO dao = new ItemDAO();
			
			boolean check = dao.update(code, categoryCode, name, price);
			
			if (check == false) {
				throw new DAOException("更新に失敗しました。");
			}
	
			return "/control?action=list";
			
//			List<Item> list = dao.findAll();
//			
//			//リクエストスコープに記憶させる
//			request.setAttribute("list", list);
//			
//			return "/db/item_list.jsp"; //表示するページを返す
		} catch (NumberFormatException e) {
			throw new DAOException("整数に変換できません。");
		}
	}

}
