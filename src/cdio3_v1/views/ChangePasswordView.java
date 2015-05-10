package cdio3_v1.views;

import cdio3_v1.shared.DALException;
import cdio3_v1.shared.FieldVerifier;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ChangePasswordView extends Composite {


	TextBox currentPassword;
	TextBox newPassword;
	TextBox newPasswordAgain;

	boolean passValid = true;

	Button cancelBtn;
	Button okBtn;

	public ChangePasswordView(OperatorDTO dto){


		VerticalPanel passwordView = new VerticalPanel();

		passwordView.add(currentPassword);
		passwordView.add(newPassword);
		passwordView.add(newPasswordAgain);

		okBtn = new Button("OK\u00F8j");
		cancelBtn = new Button("Cancel\u00F8j");
	}
		@SuppressWarnings("unused")
		private void okButtonEnabler(){
			if(newPassword == newPasswordAgain){
				okBtn.setEnabled(true);
			}
			else{
				okBtn.setEnabled(false);
			}
		
		



		currentPassword.addKeyUpHandler(new KeyUpHandler(){

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if (!FieldVerifier.isPasswordValid(currentPassword.getText())){
						currentPassword.setStyleName("gwt-TextBox-invalidEntry");
						passValid = false;

					}else{
						currentPassword.removeStyleName("gwt-TextBox-invalidEntry");
						passValid = true;
					}
					
					
				} catch (DALException e) {
					e.printStackTrace();
				}
			};	

		});
		
		newPassword.addKeyUpHandler(new KeyUpHandler(){

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if (!FieldVerifier.isPasswordValid(newPassword.getText())){
						currentPassword.setStyleName("gwt-TextBox-invalidEntry");
						passValid = false;

					}else{
						newPassword.removeStyleName("gwt-TextBox-invalidEntry");
						passValid = true;
					}
					
					
				} catch (DALException e) {
					e.printStackTrace();
				}
			};	

		});
		
		newPasswordAgain.addKeyUpHandler(new KeyUpHandler(){

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (newPassword==newPasswordAgain){
					passValid=true;

				}else{
					passValid = false;
				}
			};	

		});
		
		okButtonEnabler();
		cancelBtn.setEnabled(true);
		
	}
}
