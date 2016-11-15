package com.tiyujia.homesport.common.homepage.net;

import com.tiyujia.homesport.common.homepage.service.HomePageServiceImpl;
import com.tiyujia.homesport.common.homepage.service.Service;

import java.util.HashMap;

/**
 * Created by zzqybyb19860112 on 2016/11/10.
 */

public class HomePageDataManager {
    private static HashMap<String, Service> services = new HashMap<String, Service>();
    public static <T extends Service> T getService(Class<T> clazz) {
        if (clazz == null) {
            throw new NullPointerException("clazz == null");
        }
        T service = (T) services.get(clazz.getName());
        if (service == null) {
            synchronized (clazz) {
                if (service == null) {
                    if (clazz.isAssignableFrom(HomePageUserServiceImpl.class)) {
                        service = (T) new HomePageUserServiceImpl();
                        services.put(clazz.getName(), service);
                        service = (T) services.get(clazz.getName());
                    }
                    if (clazz.isAssignableFrom(HomePageServiceImpl.class)) {
                        service = (T) new HomePageServiceImpl();
                        services.put(clazz.getName(), service);
                        service = (T) services.get(clazz.getName());
                    }
                }
            }
        }
        return service;
    }
}