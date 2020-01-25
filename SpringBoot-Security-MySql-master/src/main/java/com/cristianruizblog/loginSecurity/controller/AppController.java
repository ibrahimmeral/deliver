package com.cristianruizblog.loginSecurity.controller;

import com.cristianruizblog.loginSecurity.entity.Client;
import com.cristianruizblog.loginSecurity.entity.Orders;
import com.cristianruizblog.loginSecurity.entity.State;
import com.cristianruizblog.loginSecurity.repository.OrderRepository;
import com.cristianruizblog.loginSecurity.service.ClientService;
import com.cristianruizblog.loginSecurity.service.OrderService;
import com.cristianruizblog.loginSecurity.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
	@Autowired
	OrderService orderService;

	@Autowired
	ClientService clientService;

	@Autowired
	StateService stateService;


	List<Orders> orders = new ArrayList<>();
	String firmName;
	Float totalTip = 0F;
	Float totalFee = 0F;

	@GetMapping({"/","/login"})
	public String index() {

		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	

	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		orderService.delete(orderService.getOrderById(id));
		return "redirect:/orders";
	}

	@GetMapping("/done/{id}")
	public String doneOrder(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		Orders order = orderService.getOrderById(id);
		State state = stateService.getStateById(1L);
		order.setState(state);
		orderService.saveOrUpdate(order);
		return "redirect:/orders";
	}


	@GetMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		clientService.delete(clientService.getClientById(id));
		return "redirect:/clients";
	}



	@GetMapping("/save")
	public String saveFeeAndTip(@RequestParam("fee") Float fee, @RequestParam("id") Long id, @RequestParam("tip") Float tip){
		Orders order = orderService.getOrderById(id);
		order.setFee(fee);
		order.setTip(tip);
		orderService.saveOrUpdate(order);
		return "redirect:/orders";
	}

	@GetMapping("/search")
	public String searchClientOrders(@RequestParam("firmName") String fName, Model model){
		List<Orders> ordersList = orderService.getOrdersByFirmNameAndDoneStatusOrderBySaveTime(fName);
		Float tTip = 0F;
		Float tFee = 0F;

		for (Orders order: ordersList) {
			tFee += order.getFee();
			tTip += order.getTip();
		}
		totalFee = tFee;
		totalTip = tTip;
		orders = ordersList;
		firmName = fName;
		System.out.println(ordersList);
		return "redirect:/summary";
	}

	@PostMapping("/save")
	public String saveFeeAndTip(Orders order){
		orderService.saveOrUpdate(order);
		return "redirect:/orders";
	}

	@GetMapping("/orders")
	public String user(Model model, @ModelAttribute("order") Orders order) {
		List<Orders> orders = orderService.getPreStatusOrdersOrderBySaveTime();
		model.addAttribute("orders", orders);
		return "orders";
	}


	@GetMapping("/summary")
	public String admin(@ModelAttribute("client")Client client, Model model) {

		model.addAttribute("orders", orders);
		model.addAttribute("totalFee", totalFee);
		model.addAttribute("totalTip", totalTip);
		model.addAttribute("firmName", firmName);
		return "summary";
	}

	@GetMapping("/createClient")
	public String createClient(@ModelAttribute("client") Client client) {
		return "createClient";
	}

	@PostMapping("/insertClient")
	public String insertClient(@ModelAttribute("client") Client client){
		clientService.saveOrUpdate(client);
		return "redirect:/createClient";
	}


	@GetMapping("fragments/header")
	public String headerfrag() {
		return "createClient";
	}

	@GetMapping("/clients")
	public String client(Model model, @ModelAttribute("client") Client client) {
		List<Client> clients = clientService.getAllOrders();
		model.addAttribute("clients", clients);
		return "clients";
	}



}
