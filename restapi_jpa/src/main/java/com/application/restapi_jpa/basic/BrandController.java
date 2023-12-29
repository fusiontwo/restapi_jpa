package com.application.restapi_jpa.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//브랜드 데이터에 대한 CRUD (Create, Read, Update, Delete) 작업을 REST API를 통해 제공

@RestController      		// @RestController 어노테이션은 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타낸다.
@RequestMapping("/brand")  // 이 컨트롤러의 모든 메서드가 /brand 경로로 매핑
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;
	
	@GetMapping  // Get 요청 처리
	public List<Brand> getAllBrands() {
//		brandRepository.findAll(); // findAll() : 테이블의 전체 데이터 반환
		return brandRepository.findAll();
	}
	
	@GetMapping("/{brandId}")  // Get 요청처리
	public Brand getBrandById(@PathVariable("brandId") String brandId) {
		return brandRepository.findById(brandId).orElse(null);  // findById(primary key) : id에 해당되는 데이터 반환
	}
	
	@PostMapping  // Post 요청 처리
	public void createBrand(@RequestBody Brand brand) {
		
		/*
		 
			- @RequestBody는 Spring Framework에서 사용하는 어노테이션으로, 
			HTTP 요청의 본문(body)에 있는 데이터(JSON,XML, 등)를 Java 객체로 변환해주는 역할을 한다. 
			
			- 주로 RESTful 웹 서비스에서 클라이언트가 서버에 데이터를 전송할 때 사용되며 
			 POST나 PUT 요청을 처리할 때 많이 사용된다.
		 
		 */
	
		brandRepository.save(brand); // 새로운 엔티티를 데이터베이스에 저장 , 이미 존재하는 엔티티의 경우 업데이트를 수행.

	}
	
	@PutMapping("/{brandId}")  // Put 요청 처리
	public void updateBrand(@PathVariable("brandId") String brandId , @RequestBody Brand brand) {  // id는 @PathVariable 어노테이션으로 전달받고 , 수정 데이터는 @RequestBody로 전달받는다. 
		
		Brand entity = brandRepository.findById(brandId).orElse(null);  // 기존에 저장되어 있는 데이터를 조회하여 수정한다.
		entity.setBrandNm(brand.getBrandNm());
		entity.setActiveYn(brand.getActiveYn());
		entity.setEnteredDt(brand.getEnteredDt());
		
		brandRepository.save(entity); // 새로운 엔티티를 데이터베이스에 저장 , 이미 존재하는 엔티티의 경우 업데이트를 수행.
	
	}
	
	@DeleteMapping("/{brandId}")  // Delete 요청 처리
	public void deleteBrand(@PathVariable("brandId") String brandId) {
		brandRepository.deleteById(brandId);  // deleteById(primary key); id에 해당되는 데이터 삭제
	}
	
}
