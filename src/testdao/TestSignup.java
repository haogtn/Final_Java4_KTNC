package testdao;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import poly.dao.UserDAO;
import poly.model.User;

public class TestSignup {
	UserDAO udao = new UserDAO();
	static int count, index;
	@Rule
	public ErrorCollector ec = new ErrorCollector();

	@BeforeClass
	public static void OpenConnect() {

	}

	public int countUser() {
		int temp = 0;
		try {
			List<User> u = udao.findAll();
			temp = u.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Before
	public void beforeUser() {
		count = countUser();
		System.out.println(count);
	}

	@Test
	public void testSignup1() {
		try {
			User user = new User();
			
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup2() {
		try {
			User user = new User();
			user.setId("");
			user.setPassword("123456");
			user.setFullname("Giang Thanh Nhật Hào");
			user.setEmail("haogtnps25509@fpt.edu.vn");
			user.setAdmin(false);
			
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null user: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup3() {
		try {
			User user = new User();
			user.setId("haogtn1");
			user.setPassword("");
			user.setFullname("Giang Thanh Nhật Hào");
			user.setEmail("haogtnps25509@fpt.edu.vn");
			user.setAdmin(false);
			
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null pass: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup4() {
		try {
			User user = new User();
			user.setId("haogtn2");
			user.setPassword("123456");
			user.setFullname("");
			user.setEmail("haogtnps25509@fpt.edu.vn");
			user.setAdmin(false);
			
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null FullName: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup5() {
		try {
			User user = new User();
			user.setId("haogtn3");user.setPassword("123456");
			user.setFullname("Giang Thanh Nhật Hào");
			user.setEmail("");user.setAdmin(false);
		
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null Email: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup6() {
		try {
			User user = new User();
			user.setId("");
			user.setPassword("123456");
			user.setFullname("Giang Thanh Nhật Hào");
			user.setEmail("haogtnps25509");
			user.setAdmin(false);
		
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check sai định dạng: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup7() {
		try {
			User user = new User();
			user.setId("haogtn4");
			user.setPassword("123456");
			user.setFullname("Giang Thanh Nhật Hào");
			user.setEmail("haogtnps25509@fpt.edu.vn");
			user.setAdmin(true);
			
		} catch (Exception e) {
			ec.addError(new Throwable("Check đầy đủ thông tin: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@After
	public void afterUser() {
		System.out.println(count);
	}

	@AfterClass
	public static void CloseConnect() {

	}

}
