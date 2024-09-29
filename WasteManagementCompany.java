public class WasteManagementCompany {
    private int companyId;
    private String name;
    private String contactInfo;
    
    //constuctor to initialize a WasteManagementCompany object
    public WasteManagementCompany(int companyId, String name, String contactInfo) {
        this.companyId = companyId;
        this.name = name;
        this.contactInfo = contactInfo;
    }
    
    //notifying the company when a trash can is full
    public void receiveNotification(String trashCanId, String location) {
        System.out.println("Notification sent to " + name + " for Trash Can ID " + trashCanId + " at " + location);
    }
}
