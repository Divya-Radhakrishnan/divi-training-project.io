package com.cognizant.truyum.Dao;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import com.cognizant.truyum.model.Cart;

import com.cognizant.truyum.model.MenuItem;

public class CartItemDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	public CartItemDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addCartItem(long userid, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userid)) {
			userCarts.get(userid).getMenuItemList().add(menuItem);
		} else {
			Cart cart = new Cart();
			List<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userid, cart);
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		// List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Cart cart = userCarts.get(userId);
		int total = 0;
		if (cart == null || cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException();
		}
		List<MenuItem> menuItemList = cart.getMenuItemList();
		for (MenuItem menuItem : menuItemList) {
			total += menuItem.getPrice();
		}
		cart.setTotal(total);
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long MenuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == MenuItemId) {
				menuItemList.remove(i);
				return;
			}
		}

	}
}
