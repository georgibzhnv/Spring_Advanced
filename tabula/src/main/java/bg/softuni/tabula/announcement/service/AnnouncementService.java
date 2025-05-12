package bg.softuni.tabula.announcement.service;

import bg.softuni.tabula.announcement.model.AnnouncementDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnouncementService {
    List<AnnouncementDTO>findAll();
}
