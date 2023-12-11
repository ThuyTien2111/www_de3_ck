package vn.edu.iuh.fit;

public class roleForm {
    private String role;

    public roleForm() {
    }

    public roleForm(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "roleForm{" +
                "role='" + role + '\'' +
                '}';
    }
}
