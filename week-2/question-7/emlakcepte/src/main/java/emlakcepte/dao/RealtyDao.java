package emlakcepte.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import emlakcepte.model.Realty;

public class RealtyDao {
	
	private static final List<Realty> realtyList = new ArrayList<>();
	private static final List<String> searchList = new ArrayList<>();
	
	public void saveRealty(Realty realty) {

		realtyList.add(realty);
	}
	
	public List<Realty> findAll(){
		return realtyList;
	}
	public void saveSearch(String searchWord) {

		searchList.add(searchWord);
	}

	public List<String> findAllSearch(){
		return searchList;
	}

}
