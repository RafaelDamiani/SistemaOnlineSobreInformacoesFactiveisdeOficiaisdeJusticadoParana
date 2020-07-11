package mb;

import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.User;
import model.UserType;
import org.hibernate.Session;
import util.HibernateUtil;
import util.PasswordUtil;
import validator.UserTypeValidator;
import validator.UserValidator;

@Named(value = "registerMB")
@RequestScoped
public class RegisterMB {
    private String email;
    private String password;
    private String name;
    private String cpf;
    private Integer idUserType;
    
    public RegisterMB() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Integer idUserType) {
        this.idUserType = idUserType;
    }

    public String registerUser() throws NoSuchAlgorithmException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        boolean valid = true;
        String response = "";
        
        UserTypeValidator userTypeValidator = new UserTypeValidator(valid);
        response = userTypeValidator.validateId(idUserType);
        valid = userTypeValidator.isValid();
        
        if (!valid)
            return response;

        UserType userType = new UserType();
        userType.setId(idUserType);
        
        UserValidator userValidator = new UserValidator(valid);
        response = userValidator.validateUser(email, password, name, cpf);
        valid = userValidator.isValid();
        
        if (!valid)
            return response;
        
        String encryptedPassword = new PasswordUtil().encryptPassword(password);
        
        User user = new User(email, encryptedPassword, name, cpf, userType);
        
        try {
            session.save(user);    
        }
        catch(RuntimeException rex) {
            if (rex.getClass().getCanonicalName().contains("ConstraintViolationException"))
                return "Já existe um usuário cadastrado com este e-mail";
            return "Ocorreu um erro ao salvar o usuário. Entre em contato com o Administrador";
        }
        
        session.getTransaction().commit();
        session.close();
        
        return "Cadastrado com sucesso!";
    }
}
