/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.feature.tests.integration;

import org.jnario.feature.tests.integration.AccessOfVariablesFeature;
import org.jnario.jnario.test.util.FeatureExecutor;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Access a variable referencing a variable from background step")
@SuppressWarnings("all")
public class AccessOfVariablesFeatureAccessAVariableReferencingAVariableFromBackgroundStep extends AccessOfVariablesFeature {
  CharSequence jnarioFile;
  
  @Test
  @Order(0)
  @Named("When I reference a variable from the background")
  public void _whenIReferenceAVariableFromTheBackground() {
    StepArguments _stepArguments = new StepArguments("package bootstrap5\nFeature: Variable test\n\tBackground:\n\t\tint x\n\t\tGiven some variable\n\t\t\tx = 3\n\tScenario: Some scenario\n\t\t\tint y\n\t\t\tWhen assigning the variable\n\t\t\t\ty = x\n\t\t\tThen it should be accessible\n\t\t\t\ty => 3\n");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    this.jnarioFile = _first;
  }
  
  @Test
  @Order(1)
  @Named("Then it should execute successfully")
  public void _thenItShouldExecuteSuccessfully() {
    FeatureExecutor.isSuccessful(this.jnarioFile);
  }
}
