public class CourseManagement {
    public static void main(String[] args) {
        while (true) {
            Session session = Session.getSession();

            System.out.print("Email: ");
            String email = session.inputScanner.nextLine();
            System.out.print("Password: ");
            String password = session.inputScanner.nextLine();

            try {
                User user = login(email, password);
				if (user != null) {
					boolean continueRunning = user.handleActions();
					if (!continueRunning) {
						break; // Exit the main loop if handleActions returned false.
					}
				}
            }
             catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static User login(String email, String password) throws Exception {
        User[] users = Session.getSession().getUserList();
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }
}
