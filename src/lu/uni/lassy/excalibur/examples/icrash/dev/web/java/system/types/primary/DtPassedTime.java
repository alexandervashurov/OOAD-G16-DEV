package lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary;

import java.io.Serializable;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.DtReal;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtReal;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtString;

public class DtPassedTime extends DtReal implements JIntIs{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 227L;

	/** The datatype passed time. */
	public DtPassedTime passedTime;
	
	/** The minimum number a passed time could be. */
	private double _minNumberPass = 0;
	
	/** The maximum number a passed time could be. */
	private double _maxNumberPass = 180;
	

	public DtPassedTime(PtReal r) {
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
