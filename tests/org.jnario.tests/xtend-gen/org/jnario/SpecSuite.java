package org.jnario;

import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.spec.tests.documentation.IntroducingJnarioSpecsSpec;
import org.jnario.spec.tests.integration.AnnotationsSpec;
import org.jnario.spec.tests.integration.AssertionSpec;
import org.jnario.spec.tests.integration.CustomizingTheSpecCreationSpec;
import org.jnario.spec.tests.integration.DefiningSpecBaseClassesSpec;
import org.jnario.spec.tests.integration.ExampleGroupSpec;
import org.jnario.spec.tests.integration.ImplicitSubjectSpec;
import org.jnario.spec.tests.integration.MockingSpec;
import org.jnario.spec.tests.integration.PendingSpec;
import org.jnario.spec.tests.integration.SetupTeardownSpec;
import org.jnario.spec.tests.integration.StaticImportsSpec;
import org.jnario.spec.tests.integration.ThrowsSpec;
import org.jnario.spec.tests.integration.UsingJUnitRulesInSpecsSpec;
import org.jnario.spec.tests.integration.UsingShouldSpec;
import org.jnario.spec.tests.integration.UsingTablesSpec;
import org.jnario.spec.tests.integration.UsingXtendSWithOperatorSpec;
import org.jnario.spec.tests.unit.compiler.CompilerSpec;
import org.jnario.spec.tests.unit.naming.ExampleSpec;
import org.jnario.spec.tests.unit.naming.OperationNameProviderSpec;
import org.jnario.spec.tests.unit.naming.SpecQualifiedNameProviderSpec;
import org.jnario.spec.tests.unit.spec.SpecExecutableProviderSpec;
import org.jnario.spec.tests.unit.validation.SpecJavaValidatorSpec;
import org.junit.runner.RunWith;

@Named("Spec")
@Contains({ AnnotationsSpec.class, AssertionSpec.class, CompilerSpec.class, CustomizingTheSpecCreationSpec.class, DefiningSpecBaseClassesSpec.class, ExampleSpec.class, ExampleGroupSpec.class, ImplicitSubjectSpec.class, IntroducingJnarioSpecsSpec.class, MockingSpec.class, OperationNameProviderSpec.class, PendingSpec.class, SetupTeardownSpec.class, SpecExecutableProviderSpec.class, SpecJavaValidatorSpec.class, SpecQualifiedNameProviderSpec.class, StaticImportsSpec.class, ThrowsSpec.class, UsingJUnitRulesInSpecsSpec.class, UsingShouldSpec.class, UsingTablesSpec.class, UsingXtendSWithOperatorSpec.class })
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class SpecSuite {
}
