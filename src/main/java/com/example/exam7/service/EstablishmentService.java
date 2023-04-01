package com.example.exam7.service;

import com.example.exam7.dao.EstablishmentDao;
import com.example.exam7.dto.EstablishmentDto;
import com.example.exam7.entity.Establishment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EstablishmentService {
    private final EstablishmentDao establishmentDao;

    public List<EstablishmentDto> showAllDishByEstablishment() {
        List<Establishment> establishments = establishmentDao.getAll();
        List<EstablishmentDto> establishmentDtos = new ArrayList<>();
        for (Establishment r : establishments) {
            EstablishmentDto establishmentDto = new EstablishmentDto();
            establishmentDto.setIdEstablishment(r.getIdEstablishment());
            establishmentDto.setName(r.getName());
            establishmentDto.setDescription(r.getDescription());
            establishmentDtos.add(establishmentDto);
        }
        return establishmentDtos;
    }
}
