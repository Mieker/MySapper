package com.mieker.mysapper.model;

import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyButton extends Button {
    int x;
    int y;
    int hiddenValue;
    boolean clicked;
    Status status;

}
