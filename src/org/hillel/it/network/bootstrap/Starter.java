package org.hillel.it.network.bootstrap;

import org.hillel.it.network.model.entity.Ad;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.service.Service;
import org.hillel.it.network.serviceImpl.ServiceImpl;

public class Starter {

	public static void main(String[] args){
		System.out.println("Progect was running");
		
		Service service = new ServiceImpl();
//		Ad ad = new Ad("Samsung","TV Plazma","Need today",3,3);
//		service.saveAd(ad);
//		System.out.println(service.getOwnerAds(3));
//		service.delAd(4);


		
		//		
//		Message message = new Message (1,2,"test", "Hello givi");
//		service.saveMessage(message);
	}
}
