package poly.store.seriver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;
import poly.store.seriver.AccountService;

@Service
public class Accountseriveimpl implements AccountService {
       
	@Autowired
	AccountDAO adao;
	@Override
	public Account findById(String username) {
		//
		return adao.findById(username).get();
	}

}
