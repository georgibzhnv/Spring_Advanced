package bg.softuni.tabula.announcement.service.impl;

import bg.softuni.tabula.announcement.model.AnnouncementDTO;
import bg.softuni.tabula.announcement.model.AnnouncementMapper;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import bg.softuni.tabula.announcement.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public List<AnnouncementDTO>findAll(){
        return announcementRepository
                .findAll()
                .stream()
                .map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto)
                .toList();
    }
}
