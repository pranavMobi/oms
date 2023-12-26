package com.oms.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product createProduct(Product product) {
        // Perform any necessary validations or business logic
        return productRepository.save(product);
    }

    public Product updateProduct(int productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            // Update existingProduct with updatedProduct attributes
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setProductClassCode(updatedProduct.getProductClassCode());
            // Update other attributes similarly

            return productRepository.save(existingProduct);
        }
        return null; // Or handle as needed
    }

    public boolean deleteProduct(int productId) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false; // Or handle as needed
    }
}