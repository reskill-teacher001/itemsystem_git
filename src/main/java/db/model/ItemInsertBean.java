package db.model;

import javax.servlet.http.HttpServletRequest;

import db.dao.DAOException;

public class ItemInsertBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {

		return "/db/item_insert.jsp"; //表示するページを返す
	}

}
