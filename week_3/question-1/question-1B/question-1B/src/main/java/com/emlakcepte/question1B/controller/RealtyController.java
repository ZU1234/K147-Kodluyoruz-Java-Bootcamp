package com.emlakcepte.question1B.controller;

import com.emlakcepte.question1B.model.Realty;
import com.emlakcepte.question1B.model.enums.RealtyCategory;
import com.emlakcepte.question1B.model.enums.TypeOfStructure;
import com.emlakcepte.question1B.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realty")
public class RealtyController {
    @Autowired
    public RealtyService realtyService;

    @GetMapping //GET  /realty  şeklinde methodu kullanmamızı sağlar.Tüm ilanları getirir.
    public List<Realty> getAll() {
        return realtyService.getAll();
    }
    /**Bireysel kullanıcılar sadece Konut tipinde ve en fazla 3 ilan yayınlayabilirler**/
    @PostMapping    //POST /realty şeklinde methodu kullanmamızı sağlar. Yeni ilan oluşturur.
    public ResponseEntity<Realty> create(@RequestBody Realty realty) {
        realtyService.createRealty(realty);
        return new ResponseEntity<>(realty, HttpStatus.CREATED);
    }
    /**Şehir ve ilçe bazlı ilan arama.kaydetme**/
    @GetMapping(value = "/{email}/{province}/{country}") //GET  /{email}/{province}/{country} şeklinde methodu kullanmamızı sağlar.Tüm
    public List<Realty> getAllByCountryAndCity(@PathVariable String email,@PathVariable String province,
                                               @PathVariable String country) {

        return realtyService.getAllByCountryAndCity(email,province,country);
    }
    //Kullanıcı yaptığı aramaları listeleler.
    @GetMapping(value = "/{email}/search") //GET  /{email}/search  şeklinde methodu kullanmamızı sağlar.
    public List<String> getAllSearchByUser(@PathVariable String email) {
        return realtyService.getAllSerachByUser(email);
    }
    //Kullanıcı yaptığı aramaları temizler.
    @DeleteMapping(value = "/{email}/search") //DELETE  /{email}/search  şeklinde methodu kullanmamızı sağlar.
    public void getAllSearchDelete(@PathVariable String email) {
        realtyService.getAllSerachByUser(email).clear();
    }
    /**Şehir vitrini 10 ilandan oluşur. Şehir bazlı vitrinler oluşturun.**/
    @GetMapping(value = "/showcase") //GET  /showcase  şeklinde methodu kullanmamızı sağlar.
    public List<Realty> getAllSearchByUser() {
        return realtyService.provinceShowcasePrint();
    }
    /**İstanbul,Ankara,İzmir Şehirlerindeki İlanlarının sayısını bulun.**/
    @GetMapping(value = "/count/{province}")
    public int getRealtyByProvinceCount(@PathVariable String province){
               return realtyService.getAllByProvinceCount(province);
    }
    /**İstanbul,Ankara,İzmir Şehirlerindeki Satılık konut İlanlarının sayısını bulun.**/
    @GetMapping(value = "/count/sale/{province}")
    public int getRealtyByProvinceSaleCount(@PathVariable String province){
        return realtyService.getRealtyByProvinceByTypeByTypeOfStructureCount(province, RealtyCategory.SALE,
                TypeOfStructure.HOUSE);
    }
}
