package io.eistern.demo.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Configuration class of vaadin default components, which allows us to generify init process for them with Spring.
 * <br/>
 * Note that all beans here MUST have prototype scope, because of Vaadin UI logic which doesn't allow us to reuse created objects in different pages
 */
@Configuration
public class VaadinDefaultComponentsConfigurer {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Button defaultButton() {
        Button button = new Button();
        return button;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Notification defaultNotification() {
        Notification notification = new Notification();
        return notification;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Text defaultText() {
        Text text = new Text("This is a sample text. Please update it");
        return text;
    }
}
