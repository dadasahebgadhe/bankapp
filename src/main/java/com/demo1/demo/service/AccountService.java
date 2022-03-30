package com.demo1.demo.service;
import com.demo1.demo.exception.ResourceNotFound;
import com.demo1.demo.model.entity.Account;
import com.demo1.demo.model.entity.User;
import com.demo1.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class AccountService {
        @Autowired
        private AccountRepository accountRepository;
        public Account saveAccount(Account account){
            return accountRepository.save(account);
        }

        public List<Account> saveAccounts(List<Account> accounts) {

            return accountRepository.saveAll(accounts);
        }

        public Account getAccountById(Long id){

            return accountRepository.findById(id).orElseThrow(null);

              }

        public Account findMyAccountById(Long userId,Long accId){

                       return accountRepository.findById(accId).orElseThrow(()->new ResourceNotFound("user not found with id:" +userId));
                   }

        public List<Account> getAccounts(){
               return accountRepository.findAll();
                  }

        public Account updateAccount(Account account){
            Account oldaccount= accountRepository.findById(account.getUserId()).orElseThrow(()->new ResourceNotFound("user not found with id:"));
            if(oldaccount!=null){
                oldaccount.setBranch(account.getBranch());
                oldaccount.setBalance(account.getBalance());
                oldaccount.setType(account.getType());
                oldaccount.setAccId(account.getAccId());
                oldaccount.setUserId(account.getUserId());
                return accountRepository.save(account);
            }
            return accountRepository.save(new Account());

        }


        public ResponseEntity<String> deleteById(Long id){
            try {
                this.accountRepository.deleteById(id);

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            }
            return ResponseEntity.status(HttpStatus.OK).build();
        }



        }

