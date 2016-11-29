package lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary;

import java.io.Serializable;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.DtReal;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtReal;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtString;


public class DtDeadlineTime extends DtReal implements JIntIs{

	/** The datatype deadline time. */
	public DtDeadlineTime deadlineTime;
	

	
	public DtDeadlineTime(PtReal r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PtBoolean is() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PtString getExpectedDataStructure() {
		// TODO Auto-generated method stub
		return null;
	}
	
}