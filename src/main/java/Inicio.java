import java.util.Iterator;
import java.util.List;

import dao.OwnerDAO;
import model.OwnerModel;

public class Inicio {

	public static void main(String[] args) {
		
		OwnerDAO ownerDao = new OwnerDAO();
		
	    //OwnerModel ownerModel = new OwnerModel(1l, "Susan", " Kelleher");
		
		List<OwnerModel> list = ownerDao.findAll();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			
			OwnerModel ownerModel = (OwnerModel) iterator.next();
			
			System.out.println(ownerModel.getFirstName() );
			
		}
		
		

	}

}
