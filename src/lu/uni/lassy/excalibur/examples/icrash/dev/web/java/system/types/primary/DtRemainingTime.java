package lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.primary;

import java.io.Serializable;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.DtReal;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtReal;
import lu.uni.lassy.excalibur.examples.icrash.dev.web.java.types.stdlib.PtString;

public class DtRemainingTime extends DtReal implements JIntIs{

	/** The datatype remaining time. */
	public DtRemainingTime remainingTime;
	
	/** The minimum number a remaining time could be. */
	private double _minNumberRemain = -180;
	
	/** The maximum number a latitude could be. */
	private double _maxNumberRemain = 180;
	
	
	public DtRemainingTime(PtReal r) {
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