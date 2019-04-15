package homework4.enums;

public enum MenuItem {


    VIEW_ISSUES("View Issues"),
    MANAGE("Manage");

    private String itemName;

    MenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
