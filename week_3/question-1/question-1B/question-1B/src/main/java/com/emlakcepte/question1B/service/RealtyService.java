package com.emlakcepte.question1B.service;

import com.emlakcepte.question1B.Repository.RealtyRepository;
import com.emlakcepte.question1B.model.ErrorMessage;
import com.emlakcepte.question1B.model.Realty;
import com.emlakcepte.question1B.model.User;
import com.emlakcepte.question1B.model.UserSearch;
import com.emlakcepte.question1B.model.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class RealtyService {
    @Autowired
    private RealtyRepository realtyRepository;


    public void createRealty(Realty realty) {

        //userService.printAllUser();
        // Bireysel kullanıcılar en fazla 3 ilan girebilir.
        if (Objects.equals(realty.getUser().getUserState(), UserState.OUT)) {
            System.out.print(ErrorMessage.login("login_up"));

        } else if (isNumberOfIndividualRealtyLessThanThree(realty) && realty.getTypeOfStructure().equals(TypeOfStructure.HOUSE)) {

            System.out.println(ErrorMessage.realty("realty>3"));
        } else {

            realtyRepository.saveRealty(realty);


        }


        //System.out.println("createRealty :: " + realty.getTitle());
    }

    public List<Realty> getAll() {
        return realtyRepository.findAll();
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
        int size = (int) realtyRepository.findAll().stream()
                .filter(obj -> obj.getUser().getName().equals(realty.getUser().getName())).count();

        return (size >= 3) && UserType.INDIVIDUAL.equals(realty.getUser().getType());

    }

    //Güncel ilanlara göre sıralama
    public List<Realty> sortingByCurrentDate() {
        return realtyRepository.findAll().stream()
                .sorted(Comparator.comparing(Realty::getPublishedDate))
                .toList();


    }

    //Düşük fiyattan yüksek fiyata sıralma
    public List<Realty> sortingByLowPrice() {
        return realtyRepository.findAll().stream()
                .sorted(Comparator.comparing(Realty::getPrice))
                .toList();
    }

    //Yüksek fiyattan düşük fiyata sıralma
    public List<Realty> sortingByHighPrice() {
        return realtyRepository.findAll().stream()
                .sorted(Comparator.comparing(Realty::getPrice).reversed())
                .toList();
    }

    public List<Realty> provinceShowcasePrint() {
        int count = 0;

        return    realtyRepository.findAll().stream()
                .filter(s->Objects.equals(s.getStatus(),RealtyType.ACTIVE))
                .takeWhile(s -> count < 11)

                .toList();



    }

    private List<String> provinceList() {

        return realtyRepository.findAll().stream().map(Realty::getProvince)
                .distinct()
                .toList();


    }

    public List<Realty> getAllByCountryAndCity(String email, String province, String country) {
        UserSearch userSearch = new UserSearch(email, province + "/" + country);
        realtyRepository.saveSearch(userSearch);
        return realtyRepository.findAll().stream()
                .filter(s -> Objects.equals(s.getCounty(), country) && Objects.equals(s.getProvince(), province))
                .toList();
    }


    public List<String> getAllSerachByUser(String email) {
        return realtyRepository.findAllSearch().stream()
                .filter(s -> Objects.equals(s.getEmail(), email))
                .map(s -> s.getSearch())
                .toList();
    }

}
