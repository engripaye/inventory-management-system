package dev.engripaye.inventorymanagementsystem.service;

import dev.engripaye.inventorymanagementsystem.dto.ProductRequest;
import dev.engripaye.inventorymanagementsystem.model.Product;
import dev.engripaye.inventorymanagementsystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest request){
        Product product = new Product();
        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setUnitPrice(request.getUnitPrice());

        return productRepository.save(product);

    }
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }


}
