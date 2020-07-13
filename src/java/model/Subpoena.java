package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_subpoena")
public class Subpoena implements Serializable {
    private Long id;
    private Date date;
    private String cpf;
    private String name;
    private Date executionDate;
    private boolean status;
    private Long prosecution;
    private User probationOfficer;
    
    public Subpoena() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(updatable=true, name="subpoena_date", nullable=false)
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(updatable=true, name="subpoena_cpf", nullable=false, length=11)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(updatable=true, name="subpoena_name", nullable=false, length=255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(updatable=true, name="subpoena_execution_date", nullable=false)
    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    @Column(updatable=true, name="subpoena_status", nullable=false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Column(updatable=true, name="subpoena_prosecution", nullable=false)
    public Long getProsecution() {
        return prosecution;
    }

    public void setProsecution(Long prosecution) {
        this.prosecution = prosecution;
    }

    @ManyToOne
    @JoinColumn(name="probation_officer_id")
    public User getProbationOfficer() {
        return probationOfficer;
    }

    public void setProbationOfficer(User probationOfficer) {
        this.probationOfficer = probationOfficer;
    }
}
