package calculator;

import calculator.Calculator;
import calculator.CalculatorSpec;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.runner.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("add[int, int]")
public class CalculatorAddIntIntSpec extends CalculatorSpec {
  @Subject
  public Calculator subject;
  
  @Test
  @Named("should add two values")
  @Order(99)
  public void shouldAddTwoValues() throws Exception {
    int _add = this.subject.add(1, 2);
    boolean _should_be = Should.should_be(_add, 3);
    Assert.assertTrue("\nExpected subject.add(1, 2) should be 3 but"
     + "\n     subject.add(1, 2) is " + _add
     + "\n     subject is " + this.subject + "\n", _should_be);
    
  }
}