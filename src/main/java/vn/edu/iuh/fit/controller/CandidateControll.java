package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.convert.RoleForm;
import vn.edu.iuh.fit.dao.CandidateDao;
import vn.edu.iuh.fit.dao.ExperienceDao;
import vn.edu.iuh.fit.enitity.Candidate;
import vn.edu.iuh.fit.enitity.Experience;

import java.util.List;

@Controller
public class CandidateControll {
    private CandidateDao candidateDao;
    private ExperienceDao experienceDao;
    @Autowired
    public CandidateControll(CandidateDao candidateDao, ExperienceDao experienceDao) {
        this.candidateDao = candidateDao;
        this.experienceDao = experienceDao;
    }

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/candidates")
    public String getAllCandidates(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "3") int size,
                                   Model model){
        Page<Candidate> candidates=candidateDao.getAll(page, size);
        model.addAttribute("candidates", candidates.getContent());
        model.addAttribute("totalCandidates", candidates.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "candidates";
    }
    @GetMapping("/candidates/{canID}")
    public String getDetailCandidates(@PathVariable long canID, Model model){
        Candidate candidate=candidateDao.getCandidate(canID);
        List<Experience> experiences=experienceDao.getExpListByCand(canID);
        model.addAttribute("candidate", candidate);
        model.addAttribute("experiences", experiences);
        return "detail";
    }
    @GetMapping("/candidate-by-role")
    public String showRoleForm(){
        return "chose-role";
    }
    @PostMapping("/candidate-by-role")
    public String getCandByRole(@ModelAttribute RoleForm roleForm, Model model){
        int role= Integer.parseInt(roleForm.getRole());
        List<Candidate> candidates=candidateDao.getCandidateListByRole(role);
        model.addAttribute("candidates", candidates);
        return "report1";
    }
    @GetMapping("/candidate-used-gmail")
    public String getCandUsedGmail(Model model){
        List<Candidate> candidates=candidateDao.getCandidateUsedGmail();
        model.addAttribute("candidates",candidates);
        return "report2";
    }
}
