package com.coffeeshop.restapi.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.coffeeshop.restapi.entity.products.ProductType;
import com.coffeeshop.restapi.service.ProductTypeService;

@RestController
@RequestMapping("/coffeeshopdemo")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;

	@RequestMapping(method = RequestMethod.POST, value = "/productype", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public @ResponseBody ResponseEntity<ProductType> createProductType(@RequestBody ProductType productType) throws Exception {
		return new ResponseEntity<ProductType>(productTypeService.saveAndUpdate(productType), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/productype/{productTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public @ResponseBody ResponseEntity<ProductType> updateProductType(@RequestBody ProductType productType, @PathVariable Long productTypeId) throws Exception {
		Optional.of(productTypeService.findProductType(productTypeId))
				.orElseThrow(() -> new IllegalArgumentException("No such product type exists"));
		productType.setId(productTypeId);
		return new ResponseEntity<ProductType>(productTypeService.saveAndUpdate(productType), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/productype/{productTypeId}", produces = "application/json")
	public @ResponseBody ResponseEntity<ProductType> deleteProductType(@PathVariable Long productTypeId)
			throws Exception {
		ProductType productType = Optional.of(productTypeService.findProductType(productTypeId))
				.orElseThrow(() -> new IllegalArgumentException("No such product type exists"));
		productType.setIsActive(false);
		return new ResponseEntity<ProductType>(productTypeService.saveAndUpdate(productType), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/productypes", produces = "application/json")
	public @ResponseBody ResponseEntity<Map<String, List<ProductType>>> getAllProducts() throws Exception {
		return new ResponseEntity<Map<String, List<ProductType>>>(productTypeService.findAllProductGroupByCategory(), HttpStatus.OK);
	}
}
