package ru.wm.accounts.controller;

import ru.wm.accounts.model.Account;
import ru.wm.accounts.model.AccountRepository;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

  AccountRepository accountRepository;

  public AccountController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/add")
  public String addAccountForm(Account account) {
    return "add";
  }

  @PostMapping("/add")
  public String addAccount(@Valid Account account,
      BindingResult result, Model model) {

    if (result.hasErrors()) {
      return "add";
    }

    accountRepository.save(account);
    return "redirect:/accounts";

  }

  @GetMapping("/accounts")
  public String accounts(Model model) {
    model.addAttribute("accounts", accountRepository.findAll());
    return "accounts";
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") long id) {

    Account account = accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Accounts not found: " + id));

    accountRepository.delete(account);
    return "redirect:/accounts";

  }

}
