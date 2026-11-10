package org.example.firstrestapi.product.service;

import org.springframework.stereotype.Service;
import org.example.firstrestapi.product.api.request.ProductRequest;
import org.example.firstrestapi.product.api.response.ProductResponse;
import org.example.firstrestapi.product.domain.Product;
import org.example.firstrestapi.product.repository.ProductRepository;
import org.example.firstrestapi.product.support.ProductMapper;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }
}
