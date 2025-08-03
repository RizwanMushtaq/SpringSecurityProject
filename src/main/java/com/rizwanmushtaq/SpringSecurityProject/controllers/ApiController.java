package com.rizwanmushtaq.SpringSecurityProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
  @GetMapping("route1")
  public String route1() {
    return "This is route 1";
  }

  @GetMapping("route2")
  public String route2() {
    return "This is route 2";
  }
}
