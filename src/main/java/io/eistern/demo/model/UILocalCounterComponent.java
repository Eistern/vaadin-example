package io.eistern.demo.model;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@SpringComponent
public class UILocalCounterComponent {
    private int state = 0;

    public int getState() {
        return state;
    }

    public void updateState() {
        ++state;
    }
}
