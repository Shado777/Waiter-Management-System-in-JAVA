package prototype_the_wms;

import Forgot_Password.Forgot_Password_Q;
import LoginFrames.*;
import ManagerMainForm.*;
import ManagerialChoises.*;
import WaiterMainForm.*;
import WaiterMainForm.WaiterMenu;
import javax.swing.*;

public class Prototype_The_WMS {

    public static void main(String[] args) {
       
    try {
        
        UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        //Initializing the login frames
        LoginChoise LCFrame = new LoginChoise();
        //WaiterLogin WLFrame = new WaiterLogin();
        //ManagerLogin MLFrame = new ManagerLogin();
        
        //Initialising the forgot password frame
        //Forgot_Password_Q forgot = new Forgot_Password_Q();
        
        //Initializing the Managerial Main frames
        //ManagerMainPageForm ManagerMain = new ManagerMainPageForm();
        //InsertFrame
        //InsertForm InEmpFrame = new InsertForm();
        //DeleteFrame
        //DeleteEmployee delEmpFrame = new DeleteEmployee();
        //Show Employee
        
        //Initialising Waiter menu Frame
        //NewShowEmployee emp = new NewShowEmployee();
        //SearchSingleEmp sng = new SearchSingleEmp();
    }
        
    
}
