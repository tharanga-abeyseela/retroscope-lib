package retroscope.rql.syntaxtree;

import retroscope.rql.RQLEnvironment;
import retroscope.rql.Types;
import java.util.ArrayList;

public class Plus extends TwoOperandExpression
{
	
	public Plus(RQLEnvironment rqlEnvironment, Expression ex1, Expression ex2)
	{ 		
		super(rqlEnvironment, ex1, ex2);
	}

	public void evaluate() throws IllegalExpressionException {
		ex1.evaluate();
		ex2.evaluate();
		RQLInterpreterValue[] ex1Vals = ex1.getValues();
		RQLInterpreterValue[] ex2Vals = ex2.getValues();
		ArrayList<RQLInterpreterValue> evalVals
				= new ArrayList<RQLInterpreterValue>(ex1Vals.length * ex2Vals.length);

		for (int i = 0; i < ex1Vals.length; i++) {
			for (int j = 0; j < ex2Vals.length; j++) {

				if (ex1Vals[i].getType() == Types.STRING || ex2Vals[j].getType() == Types.STRING) {

					Types type = RQLInterpreterValue.typeDetect(ex1Vals[i], ex2Vals[j]);
					RQLInterpreterValue expressionValue = new RQLInterpreterValue(type);

					if (ex1Vals[i].type == Types.STRING && ex2Vals[j].type == Types.STRING) {
						expressionValue.setValStr(ex1Vals[i].stringValue + ex2Vals[j].stringValue);
					} else if (ex1Vals[i].type == Types.STRING && ex2Vals[j].type == Types.DOUBLE) {
						expressionValue.setValStr(ex1Vals[i].stringValue + ex2Vals[j].floatValue);
					} else if (ex1Vals[i].type == Types.STRING && ex2Vals[j].type == Types.INT) {
						expressionValue.setValStr(ex1Vals[i].stringValue + ex2Vals[j].intValue);
					} else if (ex1Vals[i].type == Types.INT && ex2Vals[j].type == Types.STRING) {
						expressionValue.setValStr( ex1Vals[i].intValue + ex2Vals[j].stringValue);
					} else if (ex1Vals[i].type == Types.DOUBLE && ex2Vals[j].type == Types.STRING) {
						expressionValue.setValStr(ex1Vals[i].floatValue + ex2Vals[j].stringValue);
					}
					expressionValue.addAllLinks(ex1Vals[i].getLinkChain()).addAllLinks(ex2Vals[j].getLinkChain());
					evalVals.add(expressionValue);
					continue;
				}


				Types type = RQLInterpreterValue.typeDetect(ex1Vals[i], ex2Vals[j]);
				RQLInterpreterValue expressionValue = new RQLInterpreterValue(type);
				switch (type) {
					case INT:

						if (ex1Vals[i].type == Types.INT && ex2Vals[j].type == Types.INT) {
							expressionValue.setValInt(ex1Vals[i].intValue + ex2Vals[j].intValue);
						} else if (ex1Vals[i].type == Types.DOUBLE) {
							expressionValue.setValInt((int)ex1Vals[i].floatValue + ex2Vals[j].intValue);
						} else if (ex1Vals[i].type == Types.DOUBLE) {
							expressionValue.setValInt(ex1Vals[i].intValue + (int) ex2Vals[j].floatValue);
						}
						break;
                    case DOUBLE:
						if (ex1Vals[i].type == Types.DOUBLE && ex2Vals[j].type == Types.DOUBLE) {
							expressionValue.setValFloat(ex1Vals[i].intValue + ex2Vals[j].intValue);
						} else if (ex1Vals[i].type == Types.DOUBLE) {
							expressionValue.setValFloat(ex1Vals[i].floatValue + ex2Vals[j].intValue);
						} else if (ex1Vals[i].type == Types.DOUBLE) {
							expressionValue.setValFloat(ex1Vals[i].intValue + ex2Vals[j].floatValue);
						}
						break;
				}
				expressionValue.addAllLinks(ex1Vals[i].getLinkChain()).addAllLinks(ex2Vals[j].getLinkChain());
				evalVals.add(expressionValue);
			}
		}
		if (evalVals.size() == 0) {
			evalVals.add(new RQLInterpreterValue(Types.NULL));
		}
		this.values = evalVals.toArray(new RQLInterpreterValue[evalVals.size()]);
	}
}