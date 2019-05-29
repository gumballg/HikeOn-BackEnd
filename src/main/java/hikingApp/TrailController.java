package hikingApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class TrailController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrailRepository trailRepository;

    @GetMapping("/trails")
    public Iterable<Trail> trailIndex(){
        return trailRepository.findAll();
    }

    @PostMapping("/trails")
    public Trail newString(@RequestBody Trail trail, HttpSession session) throws Exception{
        User user = userRepository.findByUsername(session.getAttribute("username").toString());
        if(user == null){
            throw new Exception("must be logged in to add trail");
        }
        trail.setUser(user);
        Trail newTrail = trailRepository.save(trail);
        return newTrail;
    }

    @DeleteMapping("/trails/{id}")
    public String delete(@PathVariable("id") Long id){
        trailRepository.deleteById(id);
        return("trail deleted " + id);
    }

}
