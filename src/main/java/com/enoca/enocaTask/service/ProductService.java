package com.enoca.enocaTask.service;

import com.enoca.enocaTask.entity.Product;
import com.enoca.enocaTask.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository ;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProduct(Product newProduct, Long productId) {
       Product updateProduct = productRepository.getReferenceById(productId);
       updateProduct.setName(newProduct.getName());
       updateProduct.setPrice(newProduct.getPrice());
       updateProduct.setStockQuantity(newProduct.getStockQuantity());
       return productRepository.save(updateProduct);
    }
}
