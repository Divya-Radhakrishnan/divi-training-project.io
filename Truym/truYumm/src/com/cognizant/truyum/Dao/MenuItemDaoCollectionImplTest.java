package com.cognizant.truyum.Dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetmenuItemlistAdmin() {
		System.out.println("Item List for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
			System.out.println(new DateUtil().convertToString(menuItem.getDateOfLaunch()));
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Item List for Customer");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}

	public static void testModifyMenuItem() {
		MenuItem item = new MenuItem(5L, "Biriyani", 52.00f, true, new DateUtil().convertToDate("02/11/2022"),
				"Dessert", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItems(item);
		// System.out.println("Modify List****");
		testGetmenuItemlistAdmin();
		MenuItem modified_item = menuItemDao.getMenuItem(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);

	}

	public static void main(String[] args) {
		testGetmenuItemlistAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

}
