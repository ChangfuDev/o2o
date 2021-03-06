package com.rr.o2o.dao;

import java.util.List;

import com.rr.o2o.entity.ProductImg;

public interface ProductImgDao {
	/**
	 * Batch Add shopImgs
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);	
	List<ProductImg> queryProductImgList(long productId);
	int deleteProductImgByProductId(long productId);
}
