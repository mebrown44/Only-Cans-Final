public class NotificationSystem {
    //checking if a notification should be sent based on the fullness reports
    public void checkAndSendNotification(WasteManagementCompany company, TrashCan trashCan) {
        //send a notification if more than 2 users reported the trash can and the average fullness is >= 4.5 (method is already implemented in TrashCan.java)
        if (trashCan.shouldSendNotification()) {
            company.receiveNotification(trashCan.getTrashCanId(), trashCan.getLocation());
        }
    }
}
