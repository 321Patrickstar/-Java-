package exercise5;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test(){
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);
        StudentDAO studentDAO = new StudentDAO();
        Student index = studentDAO.getIndex(1);

    }
}
