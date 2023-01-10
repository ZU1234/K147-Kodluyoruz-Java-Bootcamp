package com.emlakcepte.question1A.Repository;

import com.emlakcepte.question1A.model.Realty;
import com.emlakcepte.question1A.model.UserSearch;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RealtyRepository {

    private static List<Realty> realtyList = new ArrayList<>();
    private static List<UserSearch> searchList = new ArrayList<>();


    public void saveRealty(Realty realty) {

        realtyList.add(realty);
    }

    public void saveSearch(UserSearch userSearch) {
        boolean search = searchList.stream()
                .filter(s -> s.getEmail().equals(userSearch.getEmail()) &&s.getSearch().equals( userSearch.getSearch()))
                .findAny().isEmpty();

        if (search) {
            System.out.println(search);
            searchList.add(userSearch);
        }


    }

    public List<Realty> findAll() {
        return realtyList;
    }

    public List<UserSearch> findAllSearch() {
        return searchList;
    }


}
