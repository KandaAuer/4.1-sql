package com.example.sql.controller;

import com.example.sql.model.Avatar;
import com.example.sql.service.AvatarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avatars")
public class AvatarController {

    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    // Возвращаем только содержимое страницы (List<Avatar>)
    @GetMapping
    public List<Avatar> getAvatars(@RequestParam int page, @RequestParam int size) {
        // Получаем страницу аватарок и извлекаем содержимое
        return avatarService.getAvatars(page, size).getContent();
    }
}
