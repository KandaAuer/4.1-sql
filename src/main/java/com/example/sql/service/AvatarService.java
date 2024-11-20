package com.example.sql.service;

import com.example.sql.model.Avatar;
import com.example.sql.repository.AvatarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;

    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    // Пагинация: возвращаем объект Page<Avatar>
    public Page<Avatar> getAvatars(int page, int size) {
        return avatarRepository.findAll(PageRequest.of(page, size));
    }
}
