package com.example.demo.salescontrol.model.service;

import com.example.demo.salescontrol.infrastructure.ProductRepository;
import com.example.demo.salescontrol.model.entities.Product;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAllByDeletedIsFalse();
	}

	@Override
	public Product insertProduct(Product product) {
		Product productSave = new Product();
		productSave.setName(product.getName());
		productSave.setQuantity(product.getQuantity());
		return productRepository.save(productSave);
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
		Product productSave = productRepository.findOneByIdAndDeletedIsFalse(id);
		productSave.setName(product.getName());
		return productRepository.save(productSave);
	}

	@Override
	public Product deleteProduct(Integer id) { 
		Product productDelete = productRepository.findOneByIdAndDeletedIsFalse(id);
		System.out.println("Product encontrado.");
		productDelete.setDeleted(true);
		return productRepository.save(productDelete);
	}

	@Override
	public void returnArchive(String doctype) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		List<Product> product = productRepository.findAllByDeletedIsFalse();

		switch (doctype) {
		case "xml":
			XStream xstream = new XStream();
			xstream.toXML(product, new FileWriter("products.xml"));
			break;
		case "csv":
			Writer writer = Files.newBufferedWriter(Paths.get("product.csv"));
			StatefulBeanToCsv<Product> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

			beanToCsv.write(product);

			writer.flush();
			writer.close();
			break;
		case "json":

			try (FileWriter file = new FileWriter("products.json")) {

				file.write(JSONArray.toJSONString(product));
				file.flush();
				break;

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}


	}

}
