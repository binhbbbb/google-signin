package org.mikotin.googlesignin;

import org.mikotin.googlesignin.events.UserLoginEvent;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;

public class UserComponent extends FormLayout {
    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private Image image;

    public UserComponent() {
        firstName = new TextField();
        firstName.setReadOnly(true);
        lastName = new TextField();
        lastName.setReadOnly(true);
        email = new TextField();
        email.setReadOnly(true);
        image = new Image();
        addFormItem(firstName, "First name");
        addFormItem(lastName, "Last name");
        addFormItem(email, "Email address");
        addFormItem(image, "Image");
    }

    public void updateUser(UserLoginEvent login) {
        if (login == null) {
            firstName.setValue("");
            lastName.setValue("");
            email.setValue("");
            image.setSrc("");
        } else {
            firstName.setValue(login.getFirstName());
            lastName.setValue(login.getLastName());
            email.setValue(login.getEmail());
            image.setSrc(login.getPictureUrl());
        }
    }
}
