package mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Subpoena;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

@Named(value = "subpoenaMB")
@SessionScoped
public class SubpoenaMB implements Serializable {
    @Inject
    private LoginMB loginMB;
    
    private boolean success;
    private boolean error;
    private String responseMessage;
    
    private Date date = new Date();
    private Long Id;
    private String cpf;
    private String name;
    private Date executionDate;
    private User probaitonOfficer;
    private Long prosecution; 
    private boolean status;
    
    public SubpoenaMB() {
    }
    
    @PostConstruct
    public void init() {
        setSuccess(false);
        setError(false);
    }
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public User getProbaitonOfficer() {
        return probaitonOfficer;
    }

    public void setProbaitonOfficer(User probaitonOfficer) {
        this.probaitonOfficer = probaitonOfficer;
    }

    public Long getProsecution() {
        return prosecution;
    }

    public void setProsecution(Long prosecution) {
        this.prosecution = prosecution;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String updatePhase() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        boolean valid = true;
        String response = "";
        
        setError(false);
        setSuccess(false);
        
        Subpoena subpoena = new Subpoena();
        
        subpoena.setId(Id);
        subpoena.setDate(date);
        subpoena.setCpf(cpf);
        subpoena.setName(name);
        subpoena.setExecutionDate(executionDate);
        subpoena.setProbationOfficer(probaitonOfficer);
        subpoena.setProsecution(prosecution);
        subpoena.setStatus(status);
        
        session.update(subpoena);

        session.getTransaction().commit();
        session.close();
        
        return response;
    }
    
    public List<Subpoena> indexSubpoena() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "select * from tb_subpoena";
        
        Query query = session.createSQLQuery(hql);
        
        List<Subpoena> subpoenas = query.list();
        
        session.getTransaction().commit();
        session.close();
        
        return subpoenas;
    }
    
    public String editSubpoena(Long idSubpoena) {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.beginTransaction();        
        
        String hql = "select * from tb_subpoena where id = :idSubpoena";
        
        Query query = session.createSQLQuery(hql).addEntity(Subpoena.class);
        query.setParameter("idSubpoena", idSubpoena);
        
        Subpoena subpoena = (Subpoena)query.uniqueResult();
        
        setId(subpoena.getId());
        setDate(subpoena.getDate());
        setCpf(subpoena.getCpf());
        setName(subpoena.getName());
        setExecutionDate(subpoena.getExecutionDate());
        setProbaitonOfficer(subpoena.getProbationOfficer());
        setProsecution(subpoena.getProsecution());
        setStatus(subpoena.isStatus());
        
        session.getTransaction().commit();
        session.close();        
        
        return "/CadastroIntimacao.xhtml";    
    }
}
