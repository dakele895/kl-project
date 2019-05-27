package com.kl.klshop.request;

import com.kl.klshop.model.ProductInventory;
import com.kl.klshop.service.ProductInventoryService;

/**
 * @Auther: dalele
 * @Date: 2019/4/20 22:09
 * @Description:
 *比如说一个商品发生了交易，那么就要修改这个商品对应的库存
 *此时就会发送请求过来，要求修改库存，那么这个可能就是所谓的data update request，数据更新请求
 *（1）删除缓存
 *（2）更新数据库
 *
 */
public class ProductInventoryDBUpdateRequest implements Request {
    /**
     * 商品库存
     */
    private ProductInventory productInventory;
    /**
     * 商品库存Service
     */
    private ProductInventoryService productInventoryService;

    public ProductInventoryDBUpdateRequest(ProductInventory productInventory,
                                           ProductInventoryService productInventoryService) {
        this.productInventory = productInventory;
        this.productInventoryService = productInventoryService;
    }

    @Override
    public void process() {
        System.out.println("===========日志===========: 数据库更新请求开始执行，商品id=" + productInventory.getProductId() + ", 商品库存数量=" + productInventory.getInventoryCnt());
        // 删除redis中的缓存
        productInventoryService.removeProductInventoryCache(productInventory);
        // 为了模拟演示先删除了redis中的缓存，然后还没更新数据库的时候，读请求过来了，这里可以人工sleep一下
	/*try {
			Thread.sleep(20000);
	} catch (InterruptedException e) {
		e.printStackTrace();
		}*/
        // 修改数据库中的库存
        productInventoryService.updateProductInventory(productInventory);
    }

    /**
     * 获取商品id
     */
    public Integer getProductId() {
        return productInventory.getProductId();
    }
}
