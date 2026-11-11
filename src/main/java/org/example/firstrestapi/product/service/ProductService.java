package org.example.firstrestapi.product.service;

import org.springframework.stereotype.Service;
import org.example.firstrestapi.product.api.request.ProductRequest;
import org.example.firstrestapi.product.api.request.UpdateProductRequest;
import org.example.firstrestapi.product.api.response.ProductResponse;
import org.example.firstrestapi.product.domain.Product;
import org.example.firstrestapi.product.repository.ProductRepository;
import org.example.firstrestapi.product.support.ProductExceptionSupplier;
import org.example.firstrestapi.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

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

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}
