package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.enitity.Candidate;
import vn.edu.iuh.fit.enitity.Experience;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExperienceDao {
    private EntityManager manager;
    @Autowired
    public ExperienceDao(EntityManager manager) {
        this.manager = manager;
    }
    @Transactional
    public boolean addExp(Experience experience){
        try{
            long totalExp= (long) manager.createQuery("select count(e) from Experience e").getSingleResult();
            experience.setExp_id(totalExp+1);
            manager.persist(experience);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public List<Experience> getExpListByCand(long canID){
        List<Experience> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM experience\n" +
                    "WHERE CanID=?";
            Query query=manager.createNativeQuery(sql, Experience.class);
            query.setParameter(1, canID);
            list=query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
