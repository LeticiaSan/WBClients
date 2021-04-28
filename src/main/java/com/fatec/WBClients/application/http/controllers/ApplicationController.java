package com.fatec.WBClients.application.http.controllers;

import com.fatec.WBClients.application.services.UserAccountService;
import com.fatec.WBClients.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

@Controller
public class ApplicationController implements WebMvcConfigurer {

    @Autowired
    private final UserAccountService profileService;

    public ApplicationController(UserAccountService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/statistics")
    public String statistics(Model model) {
        List<UserAccount> MaleList = profileService.listAllGender("M");
        List<UserAccount> FemaleList = profileService.listAllGender("F");
        List<UserAccount> OtherList = profileService.listAllGender("O");
        model.addAttribute("Male", (long) MaleList.size());
        model.addAttribute("Female", (long) FemaleList.size());
        model.addAttribute("Other", (long) OtherList.size());
        List<UserAccount> AgeList = profileService.listAll();
        model.addAttribute("AgeAverage",profileService.getAgesAverage(AgeList));
        List<UserAccount> MaleAgeList = profileService.listAllGender("M");
        model.addAttribute("MaleAgeAverage",profileService.getAgesAverage(MaleAgeList));
        List<UserAccount> FemaleAgeList = profileService.listAllGender("F");
        model.addAttribute("FemaleAgeAverage",profileService.getAgesAverage(FemaleAgeList));
        List<UserAccount> OtherAgeList = profileService.listAllGender("O");
        model.addAttribute("OtherAgeAverage",profileService.getAgesAverage(OtherAgeList));
        return "statistics";
    }

}
