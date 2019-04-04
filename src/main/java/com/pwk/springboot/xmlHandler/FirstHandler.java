package com.pwk.springboot.xmlHandler;

import com.pwk.springboot.xmlParser.FirstParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class FirstHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("first",new FirstParser());
    }
}
