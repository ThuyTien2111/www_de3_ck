package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.edu.iuh.fit.dao.CandidateDao;
import vn.edu.iuh.fit.dao.ExperienceDao;
import vn.edu.iuh.fit.enitity.Candidate;
import vn.edu.iuh.fit.enitity.Experience;

import java.time.LocalDate;

@SpringBootApplication
public class De3CkApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(De3CkApplication.class, args);
        CandidateDao candidateDao=context.getBean(CandidateDao.class);
//        for (int i = 1; i <=10; i++) {
//            candidateDao.addCandidate(new Candidate("can"+i, "can"+i+"@mail", "038849542"+i));
////            System.out.println();
//        }
        ExperienceDao experienceDao=context.getBean(ExperienceDao.class);
//        for (int i = 1; i <=4; i++) {
//            System.out.println(experienceDao.addExp(new Experience("company"+i+36, LocalDate.of(2010+i, i, i), LocalDate.of(2015+i, i, i), "desc"+i+36, -1+i, new Candidate(10))));
//        }
//        experienceDao.getExpListByCand(2).forEach(e->System.out.println(e.toString()));
//        candidateDao.getCandidateListByRole(0).forEach(c->System.out.println(c.toString()));
        candidateDao.getCandidateUsedGmail().forEach(c->System.out.println(c.toString()));

    }

}
