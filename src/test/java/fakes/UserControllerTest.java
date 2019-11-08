package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---

        @Test
        void withValidInexistingUsername_returnsOK_NO_FAKE() {
            UserController userController = new UserController(new FakeUserValidator(true, false));
            User user = new User("kalua");

            Message result = userController.create(new User("Hans"));

            Assertions.assertEquals(Message.Status.OK, result.status);
        }

        //gleicher test wie oben einfach mockito
        @Test
        void withValidInexistingUsername_returnsOK_MOCKITO() {
            UserValidator userValidator = mock(UserValidator.class);
            doReturn(true).when(userValidator).isValidUsername(anyString());
            doReturn(false).when(userValidator).doesUsernameExist(anyString());

            UserController userController = new UserController(userValidator);

            Message result = userController.create(new User("Hans"));
            Assertions.assertEquals(Message.Status.OK, result.status);
        }

/*        @Test
        void withValidInexistingUsername_returnsNOT_OK_FAKE(){
            UserController ctrl = new UserController(new FakeUserValidator(false, false));
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assertions.assertEquals(result.status, Message.Status.OK);

        }*/



   /*     @Test
   // I DON'T UNDERSTAND THIS ONE :@
        void MOCKITO_FAKE_withValidInexistingUsername_returnsOK() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            // TODO
            User user1= new User("Kalua");
            User user2= new User("Hannes");

            UserController test1 = new UserController();
            UserController test2 = new UserController();

            Message message1 = new Message();
            Method privateMessage = Message.class.getDeclaredMethod("Message", String.class);
            privateMessage.setAccessible(true);
            String returnValue = (String) privateMessage.invoke(message1, null);


            db.addUser(user1); // user1 bereits in die db rein

            //durchläuft else
            test1.create(user1);
            //durchläuft if
            test2.create(user2);

            //Assertions.assertTrue(!(!UserValidator.doesUsernameExist(user1.getUsername()) Message.createOK()));
            Assertions.assertEquals(message1, "OK");
            // 1. Test schneller machen
            // 2. UserController.create so beinflussen,
            //      dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
        }
*/

    @Test
    void withValidInexitingUserName_addUserToDB__FAKE() {
      // TODO
    }


    }
  }
}
