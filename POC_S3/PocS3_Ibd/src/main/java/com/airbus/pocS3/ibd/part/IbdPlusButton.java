package com.airbus.pocS3.ibd.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class IbdPlusButton {

	@Inject
	public IbdPlusButton() {

	}

	@PostConstruct
	public void createGui(Composite parent) {
	    new Button(parent, SWT.FLAT).setText("+");
	}

//	@CanExecute
//	public boolean canExecute() {
//	    return true;
//	}
}