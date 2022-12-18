package emlakcepte.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import emlakcepte.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;

@Service
public class RealtyService {

    private static RealtyDao realtyDao = new RealtyDao();

    @Autowired //injection
    private UserService userService;

    public void createRealty(Realty realty) {

        //userService.printAllUser();
        // Bireysel kullanıcılar en fazla 3 ilan girebilir.
        if (realty.getUser().getUserState().equals(UserState.OUT)) {
            System.out.print(ErrorMessage.login("login_up"));

        } else if (isNumberOfIndividualRealtyLessThanThree(realty) && realty.getTypeOfStructure().equals(TypeOfStructure.HOUSE)) {

            System.out.println(ErrorMessage.realty("realty>3"));
        } else {

            realtyDao.saveRealty(realty);


        }


        //System.out.println("createRealty :: " + realty.getTitle());
    }

    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    public List<String> getAllSearch() {
        return realtyDao.findAllSearch();
    }

    public void printAll(List<Realty> realtList) {
        realtList.forEach(realty -> System.out.println(realty));
    }

    public void printAllSearch(List<String> searchList) {
        searchList.forEach(searching -> System.out.println(searching));
    }

    public void getAllByProvince(String province) {

        getAll().stream()
                .filter(realty -> Objects.equals(realty.getProvince(), province))
                .forEach(realty -> System.out.println(realty));

        realtyDao.saveSearch(province);


    }

    public void getAllByCounty(String county) {
        //aramyı kayıteder.

        realtyDao.saveSearch(county);


    }

    public int getAllByProvinceCount(String province) {

        return (int) getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .count();
    }

    public List<Realty> getAllByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .toList();
    }

    //istenilen kategorideki ilanları listeler.
    public List<Realty> getAllRealtyByCategory(RealtyCategory category) {

        return getAll().stream()
                .filter(realty -> realty.getCategory().equals(category)).toList();

    }

    //Kategorideki ilan sayısını getirir.
    public int getAllRealtyByCategoryCount(RealtyCategory category) {

        return (int) getAll().stream()
                .filter(realty -> realty.getCategory().equals(category)).count();

    }

    //Şehire ait ilanları getirir.
    public List<Realty> getAllRealtyByProvinceList(String province) {

        return getAll().stream()
                .filter(realty -> realty.getProvince().equals(province)).toList();

    }

    public int getRealtyByProvinceByTypeByTypeOfStructureCount(String province, RealtyCategory realtyCategory,
                                                               TypeOfStructure typeOfStructure) {

        return (int) getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .filter(obj -> obj.getTypeOfStructure().equals(typeOfStructure))
                .filter(sls -> sls.getCategory().equals(realtyCategory))
                .count();

    }

    //Girilen Konut tipine göre verilen ilanların sayısını getirir.
    public int getAllRealtyByTypeCount(Type type) {

        return (int) getAll().stream()
                .filter(realty -> realty.getType().equals(type)).count();

    }

    public List<Realty> getActiveRealtyByUserName(User user) {

        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
                .toList();

    }

    //ilan sayısı 5'ten az ise true döner.
    public boolean isNumberOfIndividualRealtyLessThanThree(Realty realty) {
        int size = (int) realtyDao.findAll().stream()
                .filter(obj -> obj.getUser().getName().equals(realty.getUser().getName())).count();

        return (size >= 3) && UserType.INDIVIDUAL.equals(realty.getUser().getType());

    }

    //Güncel ilanlara göre sıralama
    public List<Realty> sortingByCurrentDate() {
        return realtyDao.findAll().stream()
                .sorted(Comparator.comparing(Realty::getPublishedDate))
                .toList();


    }

    //Düşük fiyattan yüksek fiyata sıralma
    public List<Realty> sortingByLowPrice() {
        return realtyDao.findAll().stream()
                .sorted(Comparator.comparing(Realty::getPrice))
                .toList();
    }

    //Yüksek fiyattan düşük fiyata sıralma
    public List<Realty> sortingByHighPrice() {
        return realtyDao.findAll().stream()
                .sorted(Comparator.comparing(Realty::getPrice).reversed())
                .toList();
    }

    public void provinceShowcasePrint(int piece) {
        AtomicInteger count = new AtomicInteger();
        count.set(0);
        showCaseList().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).distinct()
                .takeWhile(s -> count.get() < piece)
                .forEach(s -> {

                    System.out.println(s.getKey());
                    count.set(count.get() + 1);


                });


    }

    private List<String> provinceList() {

        return realtyDao.findAll().stream().map(Realty::getProvince)
                .distinct()
                .toList();


    }

    public Map<String, Integer> showCaseList() {
        Map<String, Integer> showCaseList = new HashMap<>();

        provinceList().stream().forEach(obj -> {
            int count = getAllByProvinceCount(obj);
            showCaseList.put(obj, count);


        });
        return showCaseList;
    }


}
