package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.enitity.Candidate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CandidateDao {
    private EntityManager manager;
    @Autowired
    public CandidateDao(EntityManager manager) {
        this.manager = manager;
    }
    @Transactional
    public boolean addCandidate(Candidate candidate){
        try{
            long totalCandidate= (long) manager.createQuery("select count(c) from Candidate c").getSingleResult();
            candidate.setCan_id(totalCandidate+1);
            manager.persist(candidate);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean updateCandidate(Candidate candidate){
        try{
            manager.merge(candidate);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean loginCandidate(long canID, String pass){
        try{
            Candidate candidate=manager.find(Candidate.class, canID);
            if(candidate!=null){
                //phone lam pass
                if((canID == candidate.getCan_id()) &&(pass.equalsIgnoreCase(candidate.getPhone()))){
                    return true;
                }
            }else return false;
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public Candidate getCandidate(long canID){
        try{
            return manager.find(Candidate.class, canID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public List<Candidate> getAllCandidate(){
        try{
            return manager.createQuery("select c from Candidate c").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public Page<Candidate> getAll(int page, int size){
        try{
            List<Candidate> candidates= manager.createQuery("select c from Candidate c", Candidate.class)
                    .setFirstResult(page*size)
                    .setMaxResults(size)
                    .getResultList();
            long totalCandidate= (long) manager.createQuery("select count(c) from Candidate c").getSingleResult();
            return new PageImpl<>(candidates, PageRequest.of(page, size), totalCandidate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public List<Candidate> getCandidateListByRole(int role){
        List<Candidate> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM candidate\n" +
                    "WHERE CanID IN (\n" +
                    "SELECT CanID FROM experience\n" +
                    "WHERE Role=?\n" +
                    ")";
            Query query=manager.createNativeQuery(sql, Candidate.class);
            query.setParameter(1, role);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    @Transactional
    public List<Candidate> getCandidateUsedGmail(){
        List<Candidate> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM candidate\n" +
                    "WHERE Email LIKE '%gmail%'";
            list=manager.createNativeQuery(sql, Candidate.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
