package retroscope.rql.syntaxtree.expression;


import retroscope.rql.RQLEnvironment;
import retroscope.rql.Types;
import retroscope.rql.errors.RQLRunTimeWarning;

public abstract class TwoOperandExpression extends Expression
{
	protected Expression ex1, ex2;
	public TwoOperandExpression(RQLEnvironment rqlEnvironment, Expression ex1, Expression ex2)
	{
		super(rqlEnvironment);
		this.ex1 = ex1;
		this.ex2 = ex2;
	}

    protected void emitUndefinedDataTypeWarning(String op, Types t1, Types t2) {
        RQLRunTimeWarning w = new RQLRunTimeWarning(
                RQLRunTimeWarning.WarningType.INCOMPATIBLE_TYPES,
                this.getClass().getName() + this.hashCode(),
                "Operation " + op +" is undefined for these data types: " + t1 + ", " + t2
        );
        rqlEnvironment.addRunTimeWarning(w);
    }

	public Expression getEx1() {
		return ex1;
	}

	public Expression getEx2() {
		return ex2;
	}
}