package com.petrovnikita.spring.coffeeShop.controller;


import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.form.CoffeeForm;
import com.petrovnikita.spring.coffeeShop.model.ClientInfo;
import com.petrovnikita.spring.coffeeShop.model.TaskDetailInfo;
import com.petrovnikita.spring.coffeeShop.model.TaskInfo;
import com.petrovnikita.spring.coffeeShop.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AllService allService;

    @GetMapping("/admin/allOrders")
    public String ShowAllOrders(Model model){
        List<TaskInfo> tasks = allService.getAllTask();
        model.addAttribute("allTask", tasks);

        return "show-all-order";
    }

    @GetMapping("admin/allOrders/{id}")
    public  String GetOrderDetail(Model model, @PathVariable("id") int id){
        TaskInfo task = allService.getTaskInfo(id);
        List<TaskDetailInfo> details = allService.getListTaskDetailInfo(id);
        model.addAttribute("task", task);
        model.addAttribute("details", details);
        return "get-order-detail";
    }

    @GetMapping("/admin/product")
    public String GetEditOrSaveCoffee(Model model, @RequestParam(name = "id") int id){

        CoffeeForm coffeeForm = null;
        if(id > 0) {
            Coffee coffee = allService.getCoffee(id);
            coffeeForm = new CoffeeForm(coffee);
        } else {
            coffeeForm = new CoffeeForm();
        }

        model.addAttribute("coffeeForm", coffeeForm);

        return "edit-save-coffee";
    }

    @PostMapping("/admin/saveProduct")
    public String PostEditOrSaveCoffee(Model model, @ModelAttribute("coffeeForm") @Valid CoffeeForm coffeeForm,
                                       BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getFieldError("name").getDefaultMessage());
            return "redirect:/admin/product?id=0";
        }
        allService.saveCoffee(coffeeForm);
        return "redirect:/";
    }

    @GetMapping("/admin/clients")
    public String ShowAllClients(Model model){
        List<ClientInfo> clients = allService.getAllClients();
        model.addAttribute("clients", clients);
        return "all-clients";
    }

    @GetMapping("admin/clients/{id}")
    public  String GetClientDetail(Model model, @PathVariable("id") int id){
        ClientInfo clientInfo = allService.getClientInfo(id);
        List<TaskInfo> allTask = allService.getAllTaskByClient(id);
        model.addAttribute("client", clientInfo);
        model.addAttribute("allTask", allTask);
        return "get-client-detail";
    }
}
