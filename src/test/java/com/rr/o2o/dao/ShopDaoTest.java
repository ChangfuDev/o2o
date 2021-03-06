package com.rr.o2o.dao;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rr.o2o.BaseTest;
import com.rr.o2o.entity.Area;
import com.rr.o2o.entity.PersonInfo;
import com.rr.o2o.entity.Shop;
import com.rr.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId = " + shop.getArea().getAreaId());
		System.out.println("areaId = " + shop.getArea().getAreaName());
	}
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
		
	}
	
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址ַ");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
		
	}
	
	@Test
	@Ignore
	public void testQueryShopList() {
		Shop shopCondition = new Shop(); 
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		System.out.println("ShopList.size = " + shopList.size());
	}
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop(); 
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(12L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		shopCondition.setEnableStatus(1);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 3);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("ShopList.size = " + shopList.size());
		System.out.println("Total shopList-number = " + count);
	}
}
