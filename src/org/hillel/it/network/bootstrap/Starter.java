package org.hillel.it.network.bootstrap;

import org.hillel.it.network.service.Service;
import org.hillel.it.network.serviceImpl.ServiceImpl;

public class Starter {

	public static void main(String[] args){
		System.out.println("Progect was running");

		Service service = new ServiceImpl();

		service.delFavorite(27, 17);
	}
}
