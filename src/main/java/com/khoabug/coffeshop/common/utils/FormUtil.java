package com.khoabug.coffeshop.common.utils;

import com.khoabug.coffeshop.common.repository.impl.CrudRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    private static final Logger LOGGER = LogManager.getLogger(FormUtil.class);

    public static <T> T toModel(Class<T> type, HttpServletRequest request) {
        T bean = null;
        try {
            bean = type.getConstructor().newInstance();
            BeanUtils.populate(bean, request.getParameterMap());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
        }
        return bean;
    }
}
