package fakes;

public class UserController {

    private static Database db = FileDatabase.getInstance();
    private UserValidator userValidator;

    public UserController(UserValidator userValidator){
        this.userValidator = userValidator;
    }


    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = this.userValidator.isValidUsername(user.getUsername())
                            && !this.userValidator.doesUsernameExist(user.getUsername());
        if(canCreate){
            db.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
