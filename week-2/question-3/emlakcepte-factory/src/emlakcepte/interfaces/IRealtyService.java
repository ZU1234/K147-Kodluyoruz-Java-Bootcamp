package emlakcepte.interfaces;

import emlakcepte.model.Realty;
import emlakcepte.model.User;

import java.util.List;

public interface IRealtyService {
   void createRealty(Realty realty);
    List<Realty> getAll();
    List<Realty> getAllByUserName(User user);
    void printAll(List<Realty> realtList);
    void getAllByProvince(String province);
    public List<Realty> getActiveRealtyByUserName(User user);
}
