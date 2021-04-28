package com.fatec.WBClients.application.services;

import com.fatec.WBClients.application.repositories.UserAccountRepository;
import com.fatec.WBClients.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountService(UserAccountRepository repository) {
        this.repository = repository;
    }

    public List<UserAccount> listAll() {
        return repository.findAll()
                .stream()
                .map(UserAccount::new)
                .collect(Collectors.toList());
    }

    public HashSet listAge() {
        List<UserAccount> list = repository.findAll()
                .stream()
                .map(UserAccount::new)
                .collect(Collectors.toList());
        HashSet newlist = new HashSet();
        list.forEach((temp) ->{
            newlist.add(temp.getBirthdate());
        });
        return newlist;
    }

    public int getAgesAverage(List<UserAccount> AgeList){
        HashSet newlist = new HashSet();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = today.format(formatter);


        AgeList.forEach((temp) ->{
            newlist.add((Period.between(LocalDate.parse(temp.getBirthdate(), formatter), LocalDate.parse(formattedString, formatter)).getYears()));
        });

        IntSummaryStatistics stats = newlist.stream()
                .mapToInt((x) -> (int) x)
                .summaryStatistics();


        return ((int)stats.getAverage());
    }

    public List<UserAccount> listAllGender(String Gender) {
        List<UserAccount> list = repository.findAll()
                .stream()
                .filter(userAccount -> (userAccount.getGender()).equals(Gender))
                .collect(Collectors.toList());
        return list;
    }

    public UserAccount findById(Long id) {
        return repository.findById(id).get();
    }

    public UserAccount findByName(String name) {
        return repository.findByName(name).get();
    }

    public void save(UserAccount userAccount) {
        repository.save(userAccount);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
