package fun.happyhacker.okhttpmultithreadvsasync.controllers;

import fun.happyhacker.okhttpmultithreadvsasync.service.MultiThreadService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mt")
public class MultiThreadController {

    @Resource
    private MultiThreadService multiThreadService;

    @GetMapping("/call")
    public String mtCall() {
        multiThreadService.call();

        return "success";
    }
}
