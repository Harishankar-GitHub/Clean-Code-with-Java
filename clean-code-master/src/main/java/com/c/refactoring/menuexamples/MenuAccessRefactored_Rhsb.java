package com.c.refactoring.menuexamples;

import java.util.Arrays;
import java.util.List;

public class MenuAccessRefactored_Rhsb {

    public void setAuthorizationsInEachMenus(List<MenuItem> menuItems, Role[] roles) {
    	
    	if (roles == null)
        	return;
    	
    	menuItems.stream()
    		.forEach(menuItem -> setAccessForMenuItem(menuItem, roles));
    }

	public void setAccessForMenuItem(MenuItem menuItem, Role[] roles) {
		if (doesUserHaveTheRole(roles, menuItem.getReadAccessRole()))
		{
			menuItem.setAccess(Constants.READ);
		    menuItem.setVisible(true);
		}
		
		if (doesUserHaveTheRole(roles, menuItem.getWriteAccessRole()))
		{
			menuItem.setAccess(Constants.WRITE);
		    menuItem.setVisible(true);
		}
	}

	public boolean doesUserHaveTheRole(Role[] roles, String roleToCheckFor) {
		return Arrays.stream(roles)
								.anyMatch(role -> role.getName().equals(roleToCheckFor));
	}
}
