package com.rofai.demo.controller;

import java.util.UUID;

import com.rofai.demo.domain.User;
import com.rofai.demo.service.read.UserRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*")
@Component
@RequestMapping("/administration")
public class AsistenciaController {
	@Autowired
	private UserRService userRService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getPersona(@PathVariable("id") UUID ui_iduser) {
		User user = new User();
		user = userRService.getUser(ui_iduser);
		return user;
	}
}
