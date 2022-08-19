/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.services;

import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.SateliteNotNameDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service
public interface SateliteNoNameService {
    EntityReplyDTO add(SateliteNotNameDTO p, String NameSatelite);
    SateliteNotNameDTO validateAllData(SateliteNotNameDTO data);
}
