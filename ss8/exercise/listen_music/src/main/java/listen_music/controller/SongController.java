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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String displayAll(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("songs", songService.displayAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public String formCreateSong(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }

    @PostMapping("/save")
    public String editSong(@Validated @ModelAttribute SongDTO songDTO,
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

            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Create new Song "
                    + song.getName() + " successs");
            return "redirect:/song";
        }
    }

    @GetMapping("/{id}/edit")
    public String formEditSong(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/edit")
    public String createSong(@Validated @ModelAttribute("song") SongDTO songDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model
    ) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Edit new Song "
                    + song.getName() + " successs");
            return "redirect:/song";
        }
    }
}
