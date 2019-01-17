package com.rofai.demo.controller;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rofai.demo.domain.User;
import com.rofai.demo.service.read.UserRService;
import com.rofai.demo.service.write.UserWService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*")
@Component
@RequestMapping("/administration")
public class AdministrationController {
	@Autowired
	private UserRService userRService;

	@Autowired
	private UserWService userWService;

	private static final Logger logger = LoggerFactory.getLogger(AdministrationController.class);
	private static final ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") UUID idUser) {
		logger.info("Controller - getUser(UUID ui_iduser)");
		logger.info("Input");
		logger.info("idUser: " + idUser);
		User user = new User();
		user = userRService.getUser(idUser);
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(user));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		logger.info("Controller - getUsers()");
		logger.info("Input");
		List<User> listUser = null;
		listUser = userRService.getUsers();
		logger.info("Output");
		try {
			logger.info(mapper.writeValueAsString(listUser));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return listUser;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public UUID createUser(@RequestBody String payload) {
		logger.info("Controller - getUsers()");
		logger.info("Input");
		logger.info("payload: ", payload);
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User();
		try {
			user = objectMapper.readValue(payload, User.class);
			logger.info("Output");
			return userWService.createUser(user);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			logger.info("Output");
			return null;
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateUser(@RequestBody String payload) {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new User();
		try {
			user = objectMapper.readValue(payload, User.class);
			return userWService.updateUser(user);
		} catch (Exception e) {
			logger.error("Exception: ", e);
			return false;
		}
	}

}
