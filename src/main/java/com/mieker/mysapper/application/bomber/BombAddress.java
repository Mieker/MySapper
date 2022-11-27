package com.mieker.mysapper.application.bomber;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BombAddress {
    int x;
    int y;

    public BombAddress(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
