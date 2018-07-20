package com.dongzheng.pasm.core.common.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/16 12:42
 * 8 @Modificd By:
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;    //声明会话工厂（session(用完后即死亡),connection）
    static{
        try{
            Configuration conf = new Configuration();//声明读取配置文件的类，此类在实例化时默认即读取
            // 默认会先去读取classpath下的hibernate.properties,然后读取hibernate.cfg.xml文件,后者会覆盖前者
            conf.configure();
            sessionFactory = conf.buildSessionFactory();	//创建会话工厂
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory(){		//返回会话的工厂
        return sessionFactory;
    }
    public static Session getSession(){			//从工厂打开一个新的Session并返回
        return sessionFactory.openSession();
    }
}
