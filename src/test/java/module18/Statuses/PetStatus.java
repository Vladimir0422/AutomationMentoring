package module18.Statuses;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 12/2/2018
 */


public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String status;

    PetStatus(String status) {
        this.status = status;
    }

    public String status() {
        return status;
    }
}
