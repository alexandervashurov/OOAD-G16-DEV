/*******************************************************************************
 * Copyright (c) 2014 University of Luxembourg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alfredo Capozucca - initial API and implementation
 ******************************************************************************/
package lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary;


import java.io.Serializable;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtString;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.utils.Log4JUtils;

public abstract class CtAuthenticated implements Serializable {

	private static final long serialVersionUID = 4554155096163180856L;
	
	public DtLogin login;
	public DtPassword pwd;
	public PtBoolean vpIsLogged;
	public DtKeyWord keyWord=new DtKeyWord(new PtString("collector"));

	
	public PtBoolean init(DtLogin aLogin, DtPassword aPwd){
			login = aLogin;
			Log4JUtils.getInstance().getLogger().debug(login);
			pwd = aPwd;
		
			vpIsLogged = new PtBoolean(false); 
			return new PtBoolean(true); 
	}
	
}
