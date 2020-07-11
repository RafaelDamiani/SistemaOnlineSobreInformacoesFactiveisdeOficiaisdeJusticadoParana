package mb;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterMBTest {
    
    public RegisterMBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRegisterUserSuccess() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("teste@teste.com");
        register.setPassword("abc123");
        register.setName("Teste da Silva");
        register.setCpf("26850493043");
        
        register.setIdUserType(2);
        
        String expResultSuccess = "Cadastrado com sucesso!";
        String expResultConstraint = "Já existe um usuário cadastrado com este e-mail";
        
        List<String> expResult = new ArrayList<>();
        expResult.add(expResultSuccess);
        expResult.add(expResultConstraint);
        
        String result = register.registerUser();
        
        assertTrue(expResult.contains((result)));
    }
    
    @Test
    public void testRegisterUserFailedUserTypeAdmin() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        
        register.setIdUserType(1);
        
        String expResult = "Não é permitido cadastrar um Admin";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedUserTypeIsZero() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        
        register.setIdUserType(0);
        
        String expResult = "Preencha o tipo do usuário";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedUserTypeIsNull() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        
        String expResult = "Preencha o tipo do usuário";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedEmailIsNull() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        
        register.setIdUserType(2);
        
        String expResult = "Preencha o e-mail";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedEmailIsEmpty() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("");
        register.setIdUserType(2);
        
        String expResult = "Preencha o e-mail";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedEmailIcorrectFormat() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("erro.com");
        register.setIdUserType(2);
        
        String expResult = "O e-mail está em um formato incorreto";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedPasswordNull() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setIdUserType(2);
        
        String expResult = "Preencha a senha";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedPasswordIsEmpty() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("");
        register.setIdUserType(2);
        
        String expResult = "Preencha a senha";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedPasswordMinCaracters() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("12345");
        register.setIdUserType(2);
        
        String expResult = "A senha deve ter no mínimo 6 caracteres";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedNameNull() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("123456");
        register.setIdUserType(2);
        
        String expResult = "Preencha o nome";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedNameIsEmpty() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("123456");
        register.setName("");
        register.setIdUserType(2);
        
        String expResult = "Preencha o nome";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedCPFNull() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("123456");
        register.setName("Teste da Silva");
        register.setIdUserType(2);
        
        String expResult = "Preencha o CPF";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedCPFIsEmpty() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("123456");
        register.setName("Teste da Silva");
        register.setCpf("");
        register.setIdUserType(2);
        
        String expResult = "Preencha o CPF";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRegisterUserFailedCPFMinCaracters() throws NoSuchAlgorithmException {
        RegisterMB register = new RegisterMB();
        register.setEmail("pwd@teste.com");
        register.setPassword("123456");
        register.setName("Teste da Silva");
        register.setCpf("1234567891");
        register.setIdUserType(2);
        
        String expResult = "O CPF deve ter 11 caracteres";
        String result = register.registerUser();
        assertEquals(expResult, result);
    }
}
