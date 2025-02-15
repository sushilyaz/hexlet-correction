package io.hexlet.typoreporter.web;

import io.hexlet.typoreporter.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class IndexController {

    private final WorkspaceService workspaceService;

    @GetMapping("/workspaces")
    public String index(final Model model, Principal principal) {
        if (principal != null) {
            final var email = principal.getName();
            final var wksInfoList = workspaceService.getAllWorkspacesInfoByEmail(email);
            model.addAttribute("wksInfoList", wksInfoList);
        }
        return "workspaces";
    }
}
