package vn.edu.iuh.fit.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @Column(name = "CanID")
    private long can_id;
    @Column(name = "FullName", columnDefinition = "varchar(255)")
    private String full_name;
    @Column(name = "Email", columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "Phone", columnDefinition = "varchar(15)")
    private String phone;

    public Candidate() {
    }

    public Candidate(long can_id) {
        this.can_id = can_id;
    }

    public Candidate(String full_name, String email, String phone) {
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
    }

    public Candidate(long can_id, String full_name, String email, String phone) {
        this.can_id = can_id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
    }

    public long getCan_id() {
        return can_id;
    }

    public void setCan_id(long can_id) {
        this.can_id = can_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "can_id=" + can_id +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
