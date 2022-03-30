package com.demo1.demo.controller;
import com.demo1.demo.model.entity.Account;
import com.demo1.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
    @Validated
    @RequestMapping("/api/accounts")
    @RestController
    public class AccountController {
        @Autowired
        private AccountService accountService;

        @PostMapping
        public Account addAccount(@Valid @RequestBody  Account account) {
            return accountService.saveAccount(account);
        }

        @GetMapping("/{id}")
        public Account getAccount(@PathVariable Long id) {

            return accountService.getAccountById(id);
        }
        @GetMapping ("/userid/{userId}/{accId}")
        public Account getMyAccount(@PathVariable Long userId,@PathVariable Long accId) {

            return accountService.findMyAccountById(userId, accId);
        }

        @GetMapping
        public List<Account> getAccounts(){
            return accountService.getAccounts();
        }


        @PutMapping("/{accid}")
        public Account updateAccount(@RequestBody  Account account) {
            return accountService.updateAccount(account);
        }


        @DeleteMapping ("/{accid}")
        public ResponseEntity<String> removeAccount(@PathVariable Long accid){
            return accountService.deleteById(accid);
        }


    }




