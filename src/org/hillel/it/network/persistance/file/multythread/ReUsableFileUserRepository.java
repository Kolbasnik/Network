package org.hillel.it.network.persistance.file.multythread;

import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.file.FileUserRepository;

public class ReUsableFileUserRepository extends FileUserRepository implements Runnable{

	public ReUsableFileUserRepository(String path) {
		super(path);
	}

	public void run() {

	}
}
