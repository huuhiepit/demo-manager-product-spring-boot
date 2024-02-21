package com.codegym.hue.manager_product_spring_boot.model.enumeration;

public enum ECompany {
    SAMSUNG, IPHONE, OPPO;
    public String toCustomString() {
        // Thực hiện các biến đổi hoặc xử lý chuỗi bạn muốn ở đây
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
