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

import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtBoolean;

public class CtAdministrator extends CtAuthenticated {

	private static final long serialVersionUID = -8735427459151140796L;
	
	public PtBoolean vpNeedRecovery = new PtBoolean(false);
	
	public DtLogin login;
	public DtKeyWord keyWord;
	
	public PtBoolean init(DtLogin aLogin, DtKeyWord aKeyWord){
		login = aLogin;
		keyWord = aKeyWord;
		return new PtBoolean(true);
	}
	
		
}
