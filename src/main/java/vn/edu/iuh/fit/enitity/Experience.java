package vn.edu.iuh.fit.enitity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="experience")
public class Experience {
    @Id
    @Column(name = "ExpID")
    private long exp_id;
    @Column(name = "Company", columnDefinition = "varchar(120)")
    private String company;
    @Column(name = "FromDate")
    private LocalDate from_date;
    @Column(name = "ToDate")
    private LocalDate to_date;
    @Column(name = "WorkDesc", columnDefinition = "varchar(400)")
    private String work_desc;
    @Column(name = "Role", columnDefinition = "tinyint(4)")
    private int role;
    @ManyToOne
    @JoinColumn(name = "CanID")
    private Candidate candidate;

    public Experience() {
    }

    public Experience(String company, LocalDate from_date, LocalDate to_date, String work_desc, int role, Candidate candidate) {
        this.company = company;
        this.from_date = from_date;
        this.to_date = to_date;
        this.work_desc = work_desc;
        this.role = role;
        this.candidate = candidate;
    }

    public Experience(long exp_id, String company, LocalDate from_date, LocalDate to_date, String work_desc, int role, Candidate candidate) {
        this.exp_id = exp_id;
        this.company = company;
        this.from_date = from_date;
        this.to_date = to_date;
        this.work_desc = work_desc;
        this.role = role;
        this.candidate = candidate;
    }

    public long getExp_id() {
        return exp_id;
    }

    public void setExp_id(long exp_id) {
        this.exp_id = exp_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public String getWork_desc() {
        return work_desc;
    }

    public void setWork_desc(String work_desc) {
        this.work_desc = work_desc;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "exp_id=" + exp_id +
                ", company='" + company + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", work_desc='" + work_desc + '\'' +
                ", role=" + role +
                ", candidate=" + candidate +
                '}';
    }
}
