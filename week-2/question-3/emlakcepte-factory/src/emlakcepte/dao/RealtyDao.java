package emlakcepte.dao;

import emlakcepte.model.Realty;

import java.util.ArrayList;
import java.util.List;

public class RealtyDao {
    private static List<Realty> realtyList = new ArrayList<>();

    public void saveRealty(Realty realty) {
        realtyList.add(realty);
    }

    public List<Realty> findAll(){
        return realtyList;
    }
}
