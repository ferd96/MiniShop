package poly.store.seriver.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.CategoryDAO;
import poly.store.entity.Category;
import poly.store.seriver.CategorySerive;

@Service
public class Categoryseriverimpl implements CategorySerive {
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

}
