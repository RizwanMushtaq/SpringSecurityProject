package com.rizwanmushtaq.SpringSecurityProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
  @GetMapping("/route1")
  public String route1() {
    return "Change Menu: This is route 1 ";
  }

  @GetMapping("/route2")
  public String route2() {
    return "Change Price: This is route 2 ";
  }

  @GetMapping("/route3")
  public String route3() {
    return "Order Food: This is route 3";
  }

  @GetMapping("/route4")
  public String route4() {
    return "Pay Bill: This is route 4";
  }

  @GetMapping("/route5")
  public String route5() {
    return "Drink Water - This is route 5";
  }
}
