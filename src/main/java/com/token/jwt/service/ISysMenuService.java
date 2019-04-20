package com.token.jwt.service;



import com.token.jwt.sys.MenuInfo;

import java.util.List;

public interface ISysMenuService {
	List<MenuInfo> getMenusByRoleName(String roleName);
}
