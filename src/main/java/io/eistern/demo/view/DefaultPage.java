package io.eistern.demo.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import io.eistern.demo.model.UILocalCounterComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * In this class we can practice basic interaction with Vaadin buttons.
 * <br/>
 * Annotation {@link com.vaadin.flow.router.Route} here states that this class will be used as default page with route '/'.
 * <br/>
 * Note that all dependencies of this page injected via Spring, so we won't have to write some complicated init logic in the UI class.
 *
 * @see VaadinDefaultComponentsConfigurer
 */
@Route
@PreserveOnRefresh
public class DefaultPage extends VerticalLayout {
    private final Button helloButton;
    private final Notification helloNotification;
    private final UILocalCounterComponent counterComponent;
    private final Text counterText;

    @Autowired
    public DefaultPage(Button defaultButton, Notification defaultNotification, UILocalCounterComponent counterComponent) {

        /*
         * Prepare page elements and link them
         */
        this.helloNotification = defaultNotification;
        this.helloNotification.setText("Hello, World!");

        this.helloButton = defaultButton;
        this.helloButton.setText("Click me!");

        this.counterComponent = counterComponent;
        this.counterText = new Text("You have clicked " + this.counterComponent.getState() + " times");

        this.helloButton.addClickListener(
                event -> {
                    this.helloNotification.open();
                    this.counterComponent.updateState();
                    this.counterText.setText("You have clicked " + this.counterComponent.getState() + " times");
                }
        );

        /*
         * Register initialized components
         */
        this.add(helloButton, counterText);
    }
}
