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
    private Long timeRemaining = TRAVEL_DATE.getTimeInMillis() - TODAY.getTimeInMillis();
    private Long daysRemaining = timeRemaining / (1000 * 60 * 60 * 24);
    
    @GetMapping
    public String showDaysRemaining(){
        return response(daysRemaining);
    }
    
    private String response(Long days){
        if(days.equals(0L){
            return "<h1>É AMANHA!</h1>"
        }else{
            return "Faltam "+days+" dias para o dia da nossa viagem";
        }
    }





}
