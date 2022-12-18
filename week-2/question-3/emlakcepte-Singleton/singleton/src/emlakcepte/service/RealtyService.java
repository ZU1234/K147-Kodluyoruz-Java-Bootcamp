package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;


public class RealtyService {

    private RealtyDao realtyDao = new RealtyDao();

    private RealtyService() {

    }

    public static RealtyService getInstance(){
        return RealtyService.SingletonHelper.INSTANCE;
    }
    private static class SingletonHelper{
        private static final RealtyService INSTANCE =new RealtyService();
    }


    public void createRealty(Realty realty) {


        realtyDao.saveRealty(realty);
        System.out.println("createRealty :: " + realtyDao);
        System.out.println("createRealty :: " + getInstance());
    }

    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    public void printAll(List<Realty> realtList) {
        realtList.forEach(realty -> System.out.println(realty));
    }

    public void getAllByProvince(String province) {

        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                //.count();
                .forEach(realty -> System.out.println(realty));

    }

    public List<Realty> getAllByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .toList();
    }

    public List<Realty> getActiveRealtyByUserName(User user) {

        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
                .toList();

    }

}
