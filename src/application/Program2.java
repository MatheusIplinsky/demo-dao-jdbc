package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("=== TEST 3: department Insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id: " + newDepartment.getId());
		
		System.out.println("=== TEST 4: department Update ===");
		Department dep2 = departmentDao.findById(4);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update complete!");
		
		System.out.println("=== TEST 3: department Insert ===");
		System.out.println("Enter id for delete: ");
		int idDelete = sc.nextInt();
		departmentDao.deleteById(idDelete);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
