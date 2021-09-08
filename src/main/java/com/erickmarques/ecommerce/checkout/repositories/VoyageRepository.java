package com.erickmarques.ecommerce.checkout.repositories;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/timeremainingtotravelday")
public class VoyageRepository {
    private static final Calendar TRAVEL_DATE = new GregorianCalendar(2021,Calendar.OCTOBER,20);
    private static final Calendar TODAY = new GregorianCalendar(LocalDate.now().getYear(),
            LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
    private long timeRemaining = TRAVEL_DATE.getTimeInMillis() - TODAY.getTimeInMillis();
    private long daysRemaining = timeRemaining / (1000 * 60 * 60 * 24);

    @GetMapping
    public String showDaysRemaining(){
        return "<h1><color = red>Faltam "+daysRemaining+" dias para o dia da nossa viagem</h1>";
    }





}
