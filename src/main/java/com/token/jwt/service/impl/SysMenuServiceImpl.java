package com.token.jwt.service.impl;


import com.token.jwt.domain.Menu;
import com.token.jwt.domain.SysUserRole;
import com.token.jwt.repository.SysUserRoleRepository;
import com.token.jwt.service.ISysMenuService;
import com.token.jwt.sys.MenuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author haort
 */
@Service
@CacheConfig(cacheNames = "menus")
public class SysMenuServiceImpl implements ISysMenuService {
    private final static Logger log = LoggerFactory.getLogger(SysMenuServiceImpl.class);
    @Autowired
    SysUserRoleRepository userRoleRepository;


    @Cacheable(key = "'menus:'.concat(#role)")
    @Override
    public List<MenuInfo> getMenusByRoleName(String role) {
        log.info("获取menus");
        List<MenuInfo> menus = new ArrayList<>();

        SysUserRole ur = userRoleRepository.getMenusByRoleName(role);
        Set<Menu> menuSet = ur.getMenus();
        for (Menu menu : menuSet) {
            getMenus(menu, menus);
        }
        return menus;
    }

    private void getMenus(Menu menu, List<MenuInfo> menus) {
        if (menu.getParentMenu() == null) {
            MenuInfo parentMenu = new MenuInfo();
            parentMenu.setSelected(menu.isSelected());
            parentMenu.setId(menu.getId());
            parentMenu.setLeaf(menu.isLeaf());
            parentMenu.setName(menu.getName());
            parentMenu.setPath(menu.getPath());
            parentMenu.setIcon(menu.getIcon());
            menus.add(parentMenu);
        } else {
            Menu parentMenu = menu.getParentMenu();
            int menuSize = menus.size();
            for (int i = 0; i < menuSize; i++) {
                MenuInfo m = menus.get(i);
                if (m.getId().equals(parentMenu.getId())) {
                    List<MenuInfo> subMenus = m.getMenus();
                    MenuInfo subMenu = new MenuInfo();
                    subMenu.setSelected(menu.isSelected());
                    subMenu.setId(menu.getId());
                    subMenu.setLeaf(menu.isLeaf());
                    subMenu.setName(menu.getName());
                    subMenu.setPath(menu.getPath());
                    subMenu.setIcon(menu.getIcon());
                    subMenus.add(subMenu);
                }
            }

        }
    }
}
