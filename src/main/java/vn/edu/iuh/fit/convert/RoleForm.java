package vn.edu.iuh.fit.convert;

public class RoleForm {
    private String role;

    public RoleForm() {
    }

    public RoleForm(String role) {
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
