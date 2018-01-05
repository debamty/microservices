package com.coffeeshop.restapi.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.restapi.entity.products.ProductType;
import com.coffeeshop.restapi.repository.customerorders.ProductTypeRepository;

@Service
public class ProductTypeService {
	
	@Autowired
	private ProductTypeRepository productTypeRepository;

	public ProductType saveAndUpdate(ProductType productType) {
		return wrapException(productTypeRepository->productTypeRepository.saveAndFlush(productType));
	}
	public ProductType findProductType(Long productTypeId) {
		return productTypeRepository.findOne(productTypeId);
	}
	public List<ProductType> findProductTypeBasedOnCategory(String category) {
		return productTypeRepository.findByCategory(category);
	}
	
	public Map<String,List<ProductType>> findAllProductGroupByCategory() {
		return productTypeRepository.findAll().stream().collect(Collectors.groupingBy(ProductType::getCategory));
	}
	
	private ProductType wrapException(Function<ProductTypeRepository, ProductType> applyFunction) {
		try {
			return applyFunction.apply(productTypeRepository);
		} catch (Exception ex) {
			throw ex;
		}

	}
}
