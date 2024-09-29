//this is just a simulation to see if the code works, will take user input from the website later
public class OnlyCansApplication {
    //running the program here
    public static void main(String[] args) {
        //initializing a trash can with ID 0
        TrashCan trashCan0 = new TrashCan();

        //creating users who will submit reports
        User user1 = new User(1, "Gina Agabegi", "gma61@pitt.edu");
        User user2 = new User(2, "Jane Doe", "jane@example.com");
        User user3 = new User(3, "Alice Smith", "alice@example.com");

        //initializing a waste management company
        WasteManagementCompany company1 = new WasteManagementCompany(1, "Waste Management Corp", "contact@wm.com");

        //initializing the notification system
        NotificationSystem notificationSystem = new NotificationSystem();

        //simulating users submitting a report with fullness values
        Report report1 = user1.submitReport(trashCan0, 75, 4.7);
        Report report2 = user2.submitReport(trashCan0, 1, 4.6);
        Report report3 = user3.submitReport(trashCan0, 4, 4.5);

        //users reporting their fullness for trash can 0
        trashCan0.addFullnessReport(report1.getUserId(), report1.getFullnessValue());
        trashCan0.addFullnessReport(report2.getUserId(), report2.getFullnessValue());
        trashCan0.addFullnessReport(report3.getUserId(), report3.getFullnessValue());

        //checking if the average fullness is >= 4.5 and more than 2 users have reported the trash can
        notificationSystem.checkAndSendNotification(company1, trashCan0);

        //after the trash can is emptied, mark it as empty
        trashCan0.markEmpty();
    }
}
