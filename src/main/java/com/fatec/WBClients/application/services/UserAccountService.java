package com.fatec.WBClients.application.services;

import com.fatec.WBClients.application.repositories.UserAccountRepository;
import com.fatec.WBClients.domain.UserAccount;
import org.springframework.stereotype.Service;

import javax.print.attribute.UnmodifiableSetException;
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
