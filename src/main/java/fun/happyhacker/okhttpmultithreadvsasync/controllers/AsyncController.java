package fun.happyhacker.okhttpmultithreadvsasync.controllers;

import fun.happyhacker.okhttpmultithreadvsasync.service.AsyncService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/as")
public class AsyncController {
    @Resource
    private AsyncService asyncService;

    @GetMapping("/call")
    public String asyncCall() {
        asyncService.call();

        return "success";
    }
}
