package listen_music.controller;

import listen_music.dto.SongDTO;
import listen_music.model.Song;
import listen_music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService SongService;

    @GetMapping("")
    public String displayAll(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("songs", SongService.displayAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public String formCreateSong(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }

    @PostMapping("/save")
    public String createSong(@Validated @ModelAttribute SongDTO songDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model
    ) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            SongService.save(song);
            redirectAttributes.addFlashAttribute("message", "Create new Song "
                    + song.getName() + " successs");
            return "home";
        }
    }
}
