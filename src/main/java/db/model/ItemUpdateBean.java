package db.model;

import javax.servlet.http.HttpServletRequest;

import db.bean.Item;
import db.dao.DAOException;
import db.dao.ItemDAO;

public class ItemUpdateBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエスト・パラメータを取得
		int code = Integer.parseInt(request.getParameter("code"));
		
		//UserDAOのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		Item item = dao.findByCode(code);
		
		if (item == null) {
			throw new DAOException("指定したコードのアイテムが見つかりません");
		}
		
		request.setAttribute("item", item);

		return "/db/item_update.jsp"; //表示するページを返す
	}

}
