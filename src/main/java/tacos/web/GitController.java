package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tacos.service.GitService;

import java.util.List;
import java.util.Map;

@Controller
public class GitController {

    @Autowired
    private GitService gitService;

    @GetMapping("/gitinfo")
    public Map<String, List<String>> getGitUserinfo(@RequestParam("email") String gitUserEmail){
        Map<String, List<String>> userInfo = gitService.getUserInfo(gitUserEmail);
        return userInfo;
    }
}
