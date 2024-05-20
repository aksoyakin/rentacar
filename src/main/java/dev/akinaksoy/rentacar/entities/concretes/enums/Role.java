package dev.akinaksoy.rentacar.entities.concretes.enums;

public enum Role {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_CUSTOMER("ROLE_CUSTOMER");

    private String value;

    Role(String value) {
        this.value = value;
    }

}
