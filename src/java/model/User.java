package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user_id")
public class User implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String cpf;
    //private UserType userType;
    
    public User() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(updatable=true, name="user_email", nullable=false, length=255)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(updatable=true, name="user_password", nullable=false, length=255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(updatable=true, name="user_name", nullable=false, length=255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(updatable=true, name="user_cpf", nullable=false, length=14)
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
