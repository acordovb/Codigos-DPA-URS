package com.urs.bcknd_dashboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urs.bcknd_dashboard.model.CantonModel;
import com.urs.bcknd_dashboard.model.ParroquiaModel;
import com.urs.bcknd_dashboard.model.ProvinceModel;
import com.urs.bcknd_dashboard.service.DpaService;

import java.util.List;

@RestController
@RequestMapping("/dpa")
public class DpaController {

    private DpaService dpaService;

    public DpaController(DpaService dpaService) {
        this.dpaService = dpaService;
    }

    @GetMapping("/provincias")
    public ResponseEntity<List<ProvinceModel>> getProvincias() {
        List<ProvinceModel> provincias = dpaService.getProvincias();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }

    @GetMapping("/cantones/{provinceId}")
    public ResponseEntity<List<CantonModel>> getCantones(@PathVariable("provinceId") int provinceId) {
        List<CantonModel> cantones = dpaService.getCantones(provinceId);
        return new ResponseEntity<>(cantones, HttpStatus.OK);
    }

    @GetMapping("/parroquias/{provinceId}/{cantonId}")
    public ResponseEntity<List<ParroquiaModel>> getParroquias(@PathVariable("provinceId") int provinceId,
            @PathVariable("cantonId") int cantonId) {
        List<ParroquiaModel> parroquias = dpaService.getParroquias(provinceId, cantonId);
        return new ResponseEntity<>(parroquias, HttpStatus.OK);
    }
}