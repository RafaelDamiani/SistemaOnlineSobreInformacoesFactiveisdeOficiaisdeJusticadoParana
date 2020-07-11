package model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_summons")
@SequenceGenerator(name = "seq_summons", sequenceName = "seq_summons_id")
public class Subpoena implements Serializable {
    private Long id;
    private Date date;
    
    public Subpoena() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_summons")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(updatable=true, name="summons_date", nullable=false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
