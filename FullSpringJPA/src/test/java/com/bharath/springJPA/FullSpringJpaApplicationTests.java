package com.bharath.springJPA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.bharath.springJPA.model.Product;
import com.bharath.springJPA.repo.ProductRepo;

@SpringBootTest
class FullSpringJpaApplicationTests {
	
	@Autowired
	ProductRepo repo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(2);
		product.setName("MII");
		product.setDesc("Awesome2");
		product.setPrice(1d);
		repo.save(product);
	}
	
	@Test
	public void testRead() {
	 Product product = repo.findById(1).get();
	 assertNotNull(product);
	 assertEquals("MI", product.getName());
	}
	@Test
	public void testUpdate() {
		Product product = repo.findById(1).get();
		product.setPrice(12d);
		repo.save(product);
	}
	
	@Test
	public void testdelete() {
		//Product product = repo.findById(2).get();
		if(repo.existsById(1)){//return true or false exitsbyid
			repo.deleteById(2);
		}
		
		
	}

	@Test
	public void testcount() {
			System.out.println("tot rec========>"+repo.count());
		}
	
	@Test
	public void testFindByName() {
		List<Product> findByName = repo.findByName("JIO");
		findByName.forEach(System.out::println);
	}
	@Test
	public void testFindByNameAndDesc() {
		List<Product> findByName = repo.findByNameAndDesc("JIO","TV");
		findByName.forEach(System.out::println);
	}
	@Test
	public void testFindByGreaterThan() {
		List<Product> findByName = repo.findByPriceGreaterThan(100d);
		findByName.forEach(System.out::println);
	}
	@Test
	public void testFindByContains() {
		List<Product> findByName = repo.findByDescContains("ap");
		findByName.forEach(System.out::println);
	}
	@Test
	public void testFindByBetween() {
		List<Product> findByName = repo.findByPriceBetween(000d,5000d);
		findByName.forEach(System.out::println);
	}
	@Test
	public void testFindByLike() {
		List<Product> findByName = repo.findByDescLike("%eso%");
		findByName.forEach(System.out::println);
	}
	
//	@Test
//	public void testFindByIdsIn() {
//		List<Product> findByName = repo.findByIdIn(Arrays.asList(1,2,3,4,5));
//		findByName.forEach(System.out::println);
//	}
	
	@Test
	public void testFindAllPages() {
		//Pageable pageable =  PageRequest.of(0, 1);// as we have 3 records 3 pages n one record each in each page start with 0 index
		//Pageable pageable =  PageRequest.of(0, 2);//in 0 page 2 products awesome n tv
		Pageable pageable =  PageRequest.of(1, 2);// 1 st page only 1 as we total 3 records so only lap
		Page<Product> results = repo.findAll(pageable);
		results.forEach(e->System.out.println(e.getDesc()));
	}
	@Test
	public void testfindAllSortingDescOneProperty() {
		repo.findAll(Sort.by(new Sort.Order(Direction.DESC,"price")))
		.forEach(p->System.out.println(p.getPrice()));
	}
	
	@Test
	public void testfindAllSortingAscOneProperty() {
		repo.findAll(Sort.by(new Sort.Order(null, "price")))//ascending or u can put instead of null direction.asc
		.forEach(p->System.out.println(p.getPrice()));
	}
	
	@Test
	public void testfindAllSortingDesc2Property() {
		repo.findAll(Sort.by(new Sort.Order(Direction.DESC,"price"),new Sort.Order(Direction.DESC, "name")))//first it will sort by name in descending and then on that it will sort it by price again descending
		.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testfindAllSortingDesc2DirectionProperty() {
		repo.findAll(Sort.by(new Sort.Order(Direction.DESC,"price"),new Sort.Order(Direction.ASC, "name")))//first it will sort by name in descending and then on that it will sort it by price again descending
		.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testfindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2,Direction.DESC,"price");
		repo.findAll(pageable).forEach(System.out::println);
		
	}
	
	@Test
	public void supportPageableOnCustomFinder() {
		Pageable pageable = PageRequest.of(0, 2);
		repo.findByIdIn(Arrays.asList(1,2,3), pageable).forEach(System.out::println);
		 
	}
	
	
	
	
}
