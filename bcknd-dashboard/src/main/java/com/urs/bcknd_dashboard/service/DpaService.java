package com.urs.bcknd_dashboard.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.urs.bcknd_dashboard.model.CantonModel;
import com.urs.bcknd_dashboard.model.ParroquiaModel;
import com.urs.bcknd_dashboard.model.ProvinceModel;

@Service
public class DpaService {

    private final ApiService apiService;

    public DpaService(ApiService apiService) {
        this.apiService = apiService;
    }

    @SuppressWarnings("unchecked")
    public List<ProvinceModel> getProvincias() {
        Map<String, Object> params = apiService.getDPAResponse();
        return params.entrySet().stream()
                .map(entry -> {
                    ProvinceModel province = new ProvinceModel();
                    province.setCode(entry.getKey());
                    province.setName((String) ((Map<String, Object>) entry.getValue()).get("provincia"));
                    if (province.getName() == null) {
                        province.setName("ZONA NO ASIGNADA");
                    }
                    return province;
                })
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<CantonModel> getCantones(int provinceId) {
        Map<String, Object> params = apiService.getDPAResponse();
        Map<String, Object> province = (Map<String, Object>) params.get(String.valueOf(provinceId));
        if (province != null) {
            Map<String, Object> cantones = (Map<String, Object>) province.get("cantones");
            if (cantones != null) {
                return cantones.entrySet().stream()
                        .map(entry -> {
                            CantonModel canton = new CantonModel();
                            canton.setCode(entry.getKey());
                            canton.setProvinceCode(String.valueOf(provinceId));
                            canton.setName((String) ((Map<String, Object>) entry.getValue()).get("canton"));
                            if (canton.getName() == null) {
                                canton.setName("ZONA NO ASIGNADA");
                            }
                            return canton;
                        })
                        .collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    public List<ParroquiaModel> getParroquias(int provinceId, int cantonId) {
        Map<String, Object> params = apiService.getDPAResponse();
        Map<String, Object> province = (Map<String, Object>) params.get(String.valueOf(provinceId));
        if (province != null) {
            Map<String, Object> cantones = (Map<String, Object>) province.get("cantones");
            if (cantones != null) {
                Map<String, Object> parroquia_data = (Map<String, Object>) cantones.get(String.valueOf(cantonId));
                Map<String, Object> parroquias = (Map<String, Object>) parroquia_data.get("parroquias");
                if (parroquias != null) {
                    return parroquias.entrySet().stream()
                            .map(entry -> {
                                ParroquiaModel parroquia = new ParroquiaModel();
                                parroquia.setCode(entry.getKey());
                                parroquia.setCantonCode(String.valueOf(cantonId));
                                parroquia.setProvinceCode(String.valueOf(provinceId));
                                parroquia.setName((String) entry.getValue());
                                if (parroquia.getName() == null) {
                                    parroquia.setName("ZONA NO ASIGNADA");
                                }
                                return parroquia;
                            })
                            .collect(Collectors.toList());
                }
            }
        }
        return Collections.emptyList();
    }
}