package org.hillel.it.network.persistance.file.multythread;

import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.file.FileUserRepository;

public class ReUsableFileUserRepository extends FileUserRepository implements Runnable {
	public ReUsableFileUserRepository(String path) {
		super(path);
	}

	@Override
	public synchronized void  saveUser(User user) {
		super.saveUser(user);
	}

	@Override
	public synchronized void delUser(User user) {
		super.delUser(user);
	}

	@Override
	public synchronized User searchUser(String searchParam) {
		return super.searchUser(searchParam);
	}

	@Override
	public synchronized void readData() {
		super.readData();
	}

	@Override
	public void run() {
		
	}
}
