package com.oms.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product not found ");
        }
    }

    public Product createProduct(Product product) {
        
        return productRepository.save(product);
    }

    public Product updateProduct(int productId, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
       
            productToUpdate.setProductDescription(updatedProduct.getProductDescription());
            productToUpdate.setProductClassCode(updatedProduct.getProductClassCode());
           

            return productRepository.save(productToUpdate);
        } else {
            throw new ProductNotFoundException("Product not found ");
        }
    }

    public boolean deleteProduct(int productId) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            productRepository.delete(existingProduct.get());
            return true;
        } else {
            throw new ProductNotFoundException("Product not found ");
        }
    }
}