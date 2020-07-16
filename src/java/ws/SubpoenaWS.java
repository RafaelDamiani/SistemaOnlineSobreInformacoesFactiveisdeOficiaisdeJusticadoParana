package ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Address;
import model.ProbationOfficer;
import model.Subpoena;
import model.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * REST Web Service
 *
 * @author rafae
 */
@Path("subpoena")
public class SubpoenaWS {

    @Context
    private UriInfo context;

    public SubpoenaWS() {
    }

    @GET
    @Path("probationofficers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProbationOfficers() throws Exception {
        List<User> probationOfficers = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            String hql = "select * from tb_user where user_type_id = 2 order by id";

            Query query = session.createSQLQuery(hql).addEntity(User.class);
            probationOfficers = query.list();

            session.getTransaction().commit();
            session.close();    
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        Response response = Response
                .ok()
                .entity(probationOfficers)
                .build();
        
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postSubpoena(@FormParam("date") Date date,
            @FormParam("cpf") String cpf,
            @FormParam("name") String name,
            @FormParam("status") boolean status,
            @FormParam("prosecution") Long prosecution,
            @FormParam("probationOfficer") Long probationOfficer,
            @FormParam("zipCode") String zipCode,
            @FormParam("street") String street,
            @FormParam("number") Short number,
            @FormParam("city") String city,
            @FormParam("state") String state) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Subpoena subpoena = new Subpoena();
        subpoena.setDate(date);
        subpoena.setCpf(cpf);
        subpoena.setName(name);
        subpoena.setStatus(status);

        User user = new User(probationOfficer);
        subpoena.setProbationOfficer(user);

        Address address = new Address(zipCode, street, number, city, state, subpoena);

        session.save(subpoena);
        session.save(address);

        session.getTransaction().commit();
        session.close();
    }
}
