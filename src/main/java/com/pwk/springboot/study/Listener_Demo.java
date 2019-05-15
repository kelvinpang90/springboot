package com.pwk.springboot.study;

public class Listener_Demo {

    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void click(){
        eventListener.onclickButton();
    }

    public static void main(String[] args){
        Listener_Demo demo = new Listener_Demo();

        EventListener listener = new EventListener() {
            @Override
            public void onclickButton() {
                System.out.println("haha");
            }
        };

        demo.setEventListener(listener);
        demo.click();
    }
}

interface EventListener{
    void onclickButton();
}
