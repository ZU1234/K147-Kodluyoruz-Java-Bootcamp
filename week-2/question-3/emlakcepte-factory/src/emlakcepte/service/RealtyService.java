package emlakcepte.service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.interfaces.IRealtyService;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;


import java.util.List;


public class RealtyService implements IRealtyService {

    private RealtyDao realtyDao = new RealtyDao();


    private UserService userService;

    @Override
    public void createRealty(Realty realty) {







        realtyDao.saveRealty(realty);
        System.out.println("createRealty :: " + realty.getTitle());
    }

    @Override
    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    @Override
    public void printAll(List<Realty> realtList) {
        realtList.forEach(realty -> System.out.println(realty));
    }

    @Override
    public void getAllByProvince(String province) {

        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                //.count();
                .forEach(realty -> System.out.println(realty));

    }

    @Override
    public List<Realty> getAllByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .toList();
    }

    @Override
    public List<Realty> getActiveRealtyByUserName(User user) {

        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
                .toList();

    }

}
