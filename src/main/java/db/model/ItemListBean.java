package db.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import db.bean.Item;
import db.dao.DAOException;
import db.dao.ItemDAO;

public class ItemListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//ItemDAOのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		List<Item> list = dao.findAll();
		
		//リクエストスコープに記憶させる
		request.setAttribute("list", list);

		return "/db/item_list.jsp"; //表示するページを返す
	}

}
