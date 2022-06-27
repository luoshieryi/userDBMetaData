package moe.gothiclolita.userdbmetadata.web;

import lombok.RequiredArgsConstructor;
import moe.gothiclolita.userdbmetadata.service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CompareController {

    private final CompareService userService;

    @GetMapping("/compare")
    public String compare() throws Exception {
        return userService.compare();
    }

}
