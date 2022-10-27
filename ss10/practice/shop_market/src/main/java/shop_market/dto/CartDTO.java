package shop_market.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO, Integer> productMap = new HashMap<>();

    public CartDTO() {
    }

    public CartDTO(Map<ProductDTO, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDTO, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDTO, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDTO productDTO) {
        if (productMap.containsKey(productDTO)) {
            /* update value +1 */
            Integer currentValue = productMap.get(productDTO);
            productMap.put(productDTO, currentValue+1);
        } else {
            productMap.put(productDTO, 1); /* lần đầu được thêm vào*/
        }
    }
}
