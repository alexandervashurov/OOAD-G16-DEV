package lu.uni.lassy.excalibur.examples.icrash.dev.web.java.views;


import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.environment.IcrashEnvironment;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.environment.actors.ActAdministrator;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.IcrashSystem;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary.CtAdministrator;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary.DtLogin;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary.DtPassword;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtString;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.utils.AdminActors;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.views.AdminLoginView;

import com.vaadin.ui.FormLayout;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class AdminRecovView extends HorizontalLayout implements View, Button.ClickListener, Serializable {

	private static final long serialVersionUID = -3317915013312630958L;

	IcrashSystem sys = IcrashSystem.getInstance();
	IcrashEnvironment env = IcrashEnvironment.getInstance();
	
	ActAdministrator actAdmin = env.getActAdministrator(new DtLogin(new PtString(AdminActors.values[0].name())));
	CtAdministrator ctAdmin =  (CtAdministrator) sys.getCtAuthenticated(actAdmin);

	private Label welcomeText;
	private Label secondText;
	private Label thirdText;
	
	private TextField recovTextSms;
	private TextField recovTextEmail;
	private TextField recovTextLogin;
	private TextField recovTextKey;
	private TextField recovTextNewPass;
	private TextField recovTextRepeatPass;
	
	private Button recovButtonBack;
	private Button recovButtonSms;
	private Button recovButtonEmail;
	private Button recovButtonKey;
	private Button recovButtonConfirmSms;
	private Button recovButtonConfirmEmail;
	private Button recovButtonConfirmKey;
	private Button recovButtonConfirmPass;
	
	
	transient Logger log = Log4JUtils.getInstance().getLogger();
	
	public AdminRecovView() {
		
		actAdmin.setActorUI(UI.getCurrent());
		env.setActAdministrator(actAdmin.getName(), actAdmin);
		IcrashSystem.assCtAuthenticatedActAuthenticated.replace(ctAdmin, actAdmin);
		
		log.debug("CHECK: run recovery");
		
		welcomeText = new Label("Password Recovery");
		welcomeText.setWidth("200px");
		welcomeText.setSizeUndefined();
		
		secondText = new Label("");
		secondText.setSizeUndefined();
		
		thirdText = new Label("");
		thirdText.setSizeUndefined();
		
		recovTextSms = new TextField("");
		recovTextSms.setWidth("250px");
		recovTextSms.setImmediate(true);
		recovTextSms.setVisible(false);
		recovTextSms.setInputPrompt("Write your phone number");
		
		recovTextEmail = new TextField("");
		recovTextEmail.setWidth("250px");
		recovTextEmail.setImmediate(true);
		recovTextEmail.setVisible(false);
		recovTextEmail.setInputPrompt("Write your phone email");
		
		recovTextLogin = new TextField("");
		recovTextLogin.setWidth("250px");
		recovTextLogin.setImmediate(true);
		recovTextLogin.setVisible(false);
		recovTextLogin.setInputPrompt("Write your Login");
		
		recovTextKey = new TextField("");
		recovTextKey.setWidth("250px");
		recovTextKey.setImmediate(true);
		recovTextKey.setVisible(false);
		recovTextKey.setInputPrompt("Write your Keyword");

		
		recovTextNewPass = new TextField("");
		recovTextNewPass.setWidth("250px");
		recovTextNewPass.setImmediate(true);
		recovTextNewPass.setVisible(false);
		recovTextNewPass.setInputPrompt("Write your new password");
		
		recovTextRepeatPass = new TextField("");
		recovTextRepeatPass.setWidth("250px");
		recovTextRepeatPass.setImmediate(true);
		recovTextRepeatPass.setVisible(false);
		recovTextRepeatPass.setInputPrompt("Repeat your password");
		
		
		recovButtonBack = new Button("Back to Login", this);
		recovButtonBack.setWidth("200px");
		recovButtonBack.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonBack.setImmediate(true);
		recovButtonBack.addClickListener((e)->loginButtonClick(e));
	
		
		recovButtonSms = new Button("Recovery by SMS", this);
		recovButtonSms.setWidth("200px");
		recovButtonSms.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonSms.setImmediate(true);
		recovButtonSms.addClickListener((e) ->smsButtonClick(e));
		
		recovButtonEmail = new Button("Recovery by Email", this);
		recovButtonEmail.setWidth("200px");
		recovButtonEmail.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonEmail.setImmediate(true);
		recovButtonEmail.addClickListener((e)->emailButtonClick(e));
		
		recovButtonKey = new Button("Recovery by Keyword", this);
		recovButtonKey.setWidth("200px");
		recovButtonKey.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonKey.setImmediate(true);
		recovButtonKey.addClickListener((e)->keyButtonClick(e));
		
		recovButtonConfirmSms = new Button("Confirm", this);
		recovButtonConfirmSms.setWidth("110px");
		recovButtonConfirmSms.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonConfirmSms.setImmediate(true);
		recovButtonConfirmSms.setVisible(false);
		
		
		recovButtonConfirmEmail = new Button("Confirm", this);
		recovButtonConfirmEmail.setWidth("110px");
		recovButtonConfirmEmail.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonConfirmEmail.setImmediate(true);
		recovButtonConfirmEmail.setVisible(false);
		
		recovButtonConfirmKey = new Button("Confirm", this);
		recovButtonConfirmKey.setWidth("110px");
		recovButtonConfirmKey.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonConfirmKey.setImmediate(true);
		recovButtonConfirmKey.addClickListener((e)->confButtonClick(e));
		recovButtonConfirmKey.setVisible(false);
		
		recovButtonConfirmPass = new Button("Confirm", this);
		recovButtonConfirmPass.setWidth("110px");
		recovButtonConfirmPass.addStyleName(ValoTheme.BUTTON_PRIMARY);
		recovButtonConfirmPass.setImmediate(true);
		recovButtonConfirmPass.setVisible(false);

		
		FormLayout abc = new FormLayout(recovTextSms, recovTextEmail, recovTextLogin, recovTextKey, recovTextNewPass, recovTextRepeatPass);
		FormLayout FLA = new FormLayout(recovButtonSms, recovButtonEmail, recovButtonKey, recovButtonBack);
		FormLayout conf = new FormLayout(recovButtonConfirmSms, recovButtonConfirmEmail, recovButtonConfirmKey, recovButtonConfirmPass);
		VerticalLayout welcomeLayout = new VerticalLayout(welcomeText, FLA);
		VerticalLayout leftVL = new VerticalLayout(welcomeLayout); 
		VerticalLayout secondLayout = new VerticalLayout(secondText, abc);
		VerticalLayout middleVL = new VerticalLayout(secondLayout);
		VerticalLayout confLayout = new VerticalLayout(thirdText, conf);
		VerticalLayout rightVL = new VerticalLayout(confLayout);
		
		addComponent(leftVL);
		addComponent(middleVL);
		addComponent(rightVL);
		
		welcomeLayout.setComponentAlignment(welcomeText, Alignment.MIDDLE_LEFT);
		welcomeLayout.setComponentAlignment(FLA, Alignment.MIDDLE_LEFT);
		
		
		secondLayout.setComponentAlignment(secondText, Alignment.MIDDLE_CENTER);
		secondLayout.setComponentAlignment(abc, Alignment.MIDDLE_CENTER);
		
		confLayout.setComponentAlignment(thirdText, Alignment.MIDDLE_RIGHT);
		confLayout.setComponentAlignment(conf, Alignment.MIDDLE_RIGHT);
		
		setSizeFull();
		
		FLA.setSizeUndefined();
		abc.setSizeUndefined();
		conf.setSizeUndefined();
		
		welcomeLayout.setSizeUndefined();
		secondLayout.setSizeUndefined();
		confLayout.setSizeUndefined();
		rightVL.setSizeFull();
		leftVL.setSizeFull();
		middleVL.setSizeFull();
		
		leftVL.setComponentAlignment(welcomeLayout, Alignment.MIDDLE_RIGHT);
		middleVL.setComponentAlignment(secondLayout, Alignment.MIDDLE_CENTER);
		rightVL.setComponentAlignment(confLayout, Alignment.MIDDLE_CENTER);
		
		
		
		
		setExpandRatio(leftVL, 10);
		setExpandRatio(middleVL, 10);
		setExpandRatio(rightVL, 10);
	}

	public void loginButtonClick(ClickEvent event){
		CtAdministrator ctAdmin =  (CtAdministrator) sys.getCtAuthenticated(actAdmin);
		ctAdmin.vpNeedRecovery = new PtBoolean(false);
		Page.getCurrent().reload();
	}
	
	public void smsButtonClick(ClickEvent event){
		recovTextSms.setVisible(true);
		recovTextEmail.setVisible(false);
		recovTextLogin.setVisible(false);
		recovTextKey.setVisible(false);
		recovTextNewPass.setVisible(false);
		recovTextRepeatPass.setVisible(false);
		recovButtonConfirmSms.setVisible(true);
		recovButtonConfirmEmail.setVisible(false);
		recovButtonConfirmKey.setVisible(false);
		recovButtonConfirmPass.setVisible(false);
		
		
	}
	public void emailButtonClick(ClickEvent event){
		recovTextSms.setVisible(false);
		recovTextEmail.setVisible(true);
		recovTextLogin.setVisible(false);
		recovTextKey.setVisible(false);
		recovTextNewPass.setVisible(false);
		recovTextRepeatPass.setVisible(false);
		recovButtonConfirmSms.setVisible(false);
		recovButtonConfirmEmail.setVisible(true);
		recovButtonConfirmKey.setVisible(false);
		recovButtonConfirmPass.setVisible(false);
		
	}
	public void keyButtonClick(ClickEvent event){
		recovTextSms.setVisible(false);
		recovTextEmail.setVisible(false);
		recovTextLogin.setVisible(true);
		recovTextKey.setVisible(true);
		recovTextNewPass.setVisible(false);
		recovTextRepeatPass.setVisible(false);
		recovButtonConfirmSms.setVisible(false);
		recovButtonConfirmEmail.setVisible(false);
		recovButtonConfirmKey.setVisible(true);
		recovButtonConfirmPass.setVisible(false);
		
	}
	public void confButtonClick(ClickEvent event){
		recovTextSms.setVisible(false);
		recovTextEmail.setVisible(false);
		recovTextLogin.setVisible(false);
		recovTextKey.setVisible(false);
		recovTextNewPass.setVisible(true);
		recovTextRepeatPass.setVisible(true);
		recovButtonConfirmSms.setVisible(false);
		recovButtonConfirmEmail.setVisible(false);
		recovButtonConfirmKey.setVisible(false);
		recovButtonConfirmPass.setVisible(true);	
	}
	
	
	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
	

