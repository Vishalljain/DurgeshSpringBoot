package com.bharath.springJPA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.springJPA.entity.Image;
import com.bharath.springJPA.repos.ImageRepository;

@SpringBootTest
class FileDataSaveRetriveJpaApplicationTests {

	
	@Autowired
	ImageRepository imageRepository;
	@Test
	public void testImageSave() throws IOException {
		Image img = new Image();
		img.setId(1);
		img.setName("Maven.jpg");
		File file = new File("C:\\Users\\Vishal\\Desktop\\TCS ONBOARDING\\vishal photo.jpg");
		byte fileContent[]=new byte[(int)file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(fileContent);//the fileInputStream will read the contents of the file and it will save it into fileContent
		img.setData(fileContent);
		imageRepository.save(img);
		fileInputStream.close();
		
	}
	
	@Test
	public void readImage() throws Exception {
		
		Image img = imageRepository.findById(1L).get();
		File file = new File("C:\\Users\\Vishal\\Desktop\\save\\"+img.getName());
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(img.getData());
		
	}
	
	

}
