package module18.Statuses;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 12/2/2018
 */


public enum OrderStatus {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String orderStatus() {
        return orderStatus;
    }
}
