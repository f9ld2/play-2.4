package vn.fabrica.validators;

import play.data.validation.Constraints.Validator;
import play.libs.F.Tuple;
import org.apache.commons.beanutils.BeanUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator extends Validator<Object> implements ConstraintValidator<FieldMatch, Object>
{
	final static public String message = "error.fieldmatch";
	
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object object, final ConstraintValidatorContext context)
    {
    	try
        {
	    	final Object firstObj = BeanUtils.getProperty(object, firstFieldName);
	        final Object secondObj = BeanUtils.getProperty(object, secondFieldName);
	        
	    	System.out.println("------------------------------------------------------------------");
	    	System.out.println(firstFieldName + ":" + firstObj);
	    	System.out.println(secondFieldName+ ":" + secondObj);
	        System.out.println(object);
	        System.out.println("------------------------------------------------------------------");
	        context.disableDefaultConstraintViolation();
	        context.buildConstraintViolationWithTemplate(message).addPropertyNode(firstFieldName).addConstraintViolation();
        }
        catch (final Exception ignore)
        {}
    	
        return false;
    }

	@Override
	public boolean isValid(Object object) {
		return false;
	}

	@Override
	public Tuple<String, Object[]> getErrorMessageKey() {
		return play.libs.F.Tuple(message, new Object[] { firstFieldName, secondFieldName });
	}
}