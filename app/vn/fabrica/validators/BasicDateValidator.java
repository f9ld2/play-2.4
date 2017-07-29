package vn.fabrica.validators;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import play.data.validation.Constraints.Validator;
import play.libs.F.Tuple;
import vn.fabrica.dao.UserDAO;

public class BasicDateValidator extends Validator<String> implements ConstraintValidator<BasicDate, String>{
	final static public String message = "error.basicdate";

	private String pattern;
	private long fraction;
	
	@Inject
    private UserDAO userDAO;
	
	@Override
	public void initialize(BasicDate constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
		this.fraction = constraintAnnotation.fraction();
	}
	
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        return isValid(object);
	}

	@Override
	public boolean isValid(String object) {
		System.out.println("------------------------------------------------------------------");
		System.out.println(object);
		System.out.println(pattern);
		System.out.println(fraction);
		System.out.println(userDAO.count());
		System.out.println("------------------------------------------------------------------");
		return false;
	}

	@Override
	public Tuple<String, Object[]> getErrorMessageKey() {
		return play.libs.F.Tuple(message, new Object[] { fraction });
	}
}
