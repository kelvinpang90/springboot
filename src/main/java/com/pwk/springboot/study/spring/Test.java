package com.pwk.springboot.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test {
    public void mainTest() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        Product product = sqlSession.selectOne("com.reborn.mapper.ProductMapper.findProductById",1);
//        System.out.println(product);

//        List<Product> products = sqlSession.selectList("com.reborn.mapper.ProductMapper.findProductByName","g");
//        System.out.println(products);
//
//        product = new Product();
//        product.setName("a");
//        product.setDescription("");
//        products = sqlSession.selectList("com.reborn.mapper.ProductMapper.findProductByNameAndDescription",product);
//        System.out.println(products);
//
//        product = new Product();
//        product.setName("");
//        product.setDescription("");
//        product.setPrice(10f);
//        products = sqlSession.selectList("com.reborn.mapper.ProductMapper.findProductByNameOrDescription",product);
//        System.out.println(products);

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        products = sqlSession.selectList("com.reborn.mapper.ProductMapper.findProductByIds",list);
//        System.out.println(products);

//        Product product = new Product();
//        product.setName("a");
//        List<Product> products = sqlSession.selectList("com.reborn.mapper.ProductMapper.findProductByBind",product);
//        System.out.println(products);

//        product = new Product();
//        product.setName("strawberry");
//        product.setPrice(50f);
//        product.setDescription("red");
//        product.setDetail("sweet");
//        int row = sqlSession.insert("com.reborn.mapper.ProductMapper.addProduct",product);
//        sqlSession.commit();
//        System.out.println(row);

//        product.setId(1);
//        product.setName("Apple");
//        product.setDescription("USA Apple");
//        product.setPrice(100f);
//        product.setDetail("good for health");
//        System.out.println(product);
//        sqlSession.update("com.reborn.mapper.ProductMapper.updateProduct",product);
//        sqlSession.commit();

//        sqlSession.delete("com.reborn.mapper.ProductMapper.deleteProduct",7);
//        sqlSession.commit();

//        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
//        System.out.println(userMapper.findUserById2(11));

//
//        user = sqlSession.selectOne("com.reborn.mapper.UserMapper.findUserById2",11);
//        System.out.println(user);

//        UserAddress userAddress = sqlSession.selectOne("com.reborn.mapper.UserAddressMapper.findAddressById",1);
//        System.out.println(userAddress);

//        UserInfo userInfo = sqlSession.selectOne("com.reborn.mapper.UserInfoMapper.findUserInfoById2",2);
//        System.out.println(userInfo);

//        UserInfo userInfo = sqlSession.selectOne("com.reborn.mapper.UserInfoMapper.findUserInfoById",2);
//        System.out.println(userInfo);

    }
}
