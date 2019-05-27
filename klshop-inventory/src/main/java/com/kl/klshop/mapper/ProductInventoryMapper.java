package com.kl.klshop.mapper;

import com.kl.klshop.model.ProductInventory;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: dalele
 * @Date: 2019/4/20 22:22
 * @Description:k库存数量mapper
 */
public interface ProductInventoryMapper {


    /**
     * 更新库存数量
     */
    void updateProductInventory(ProductInventory productInventory);



    /**
     * 根据商品id查询商品库存信息
     * @param productId 商品id
     * @return 商品库存信息
     */
    ProductInventory findProductInventory(@Param("productId") Integer productId);
}
