package com.infybuzz.cloud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuesterService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String fruitSupplier = "https://942384f8-3bde-4c28-afc1-d0d3b7045786.mock.pstmn.io/fruits";
	private static final String vegetableSupplier = "https://6f09336b-9208-4385-ab15-61362072f2d1.mock.pstmn.io/vegetables";
	private static final String grainSupplier = "https://8e372a8f-1ae4-47bf-8a18-995ebe78c627.mock.pstmn.io/grains";

	List<QuesterPojo> questerPojoList = null;
	HashMap<String, String> itemList = null;

	public List<QuesterPojo> getAllItemList(int quantity) throws ProductNotFoundException {
		List<QuesterPojo> sortedList = new ArrayList<QuesterPojo>();
		questerPojoList = new ArrayList<QuesterPojo>();
		itemList = new HashMap<String, String>();
		itemList.put("fruits", fruitSupplier);
		itemList.put("vegetables", vegetableSupplier);
		itemList.put("grains", grainSupplier);
		for (Map.Entry<String, String> set : itemList.entrySet()) {
			getItemsFromApi(set.getKey());
		}
		for (QuesterPojo value : questerPojoList) {
			if (value.getQty() <= quantity)
				sortedList.add(value);
		}
		Collections.sort(sortedList);
		questerPojoList.clear();
		if (sortedList.isEmpty())
			throw new ProductNotFoundException();
		else
			return sortedList;
	}

	private List<QuesterPojo> getItemsFromApi(String key) {
		// TODO Auto-generated method stub
		String url = itemList.get(key);
		ResponseEntity<QuesterPojo[]> responseEntity = restTemplate.getForEntity(url, QuesterPojo[].class);
		QuesterPojo[] questPojo = responseEntity.getBody();
		for (QuesterPojo fruits : questPojo) {
			questerPojoList.add(fruits);
		}
		return questerPojoList;
	}

}
