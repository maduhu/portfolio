/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.products.spi;


import io.mifos.portfolio.api.v1.domain.Case;
import io.mifos.portfolio.api.v1.domain.ChargeDefinition;
import io.mifos.portfolio.api.v1.domain.CostComponent;
import io.mifos.portfolio.api.v1.domain.Pattern;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Myrle Krantz
 */
public interface PatternFactory {
  Pattern pattern();
  List<ChargeDefinition> charges();
  void persistParameters(Long caseId, String parameters);
  void changeParameters(Long caseId, String parameters);
  Optional<String> getParameters(Long caseId);
  Set<String> getNextActionsForState(Case.State state);
  List<CostComponent> getCostComponentsForAction(String productIdentifier, String caseIdentifier, String actionIdentifier);
  ProductCommandDispatcher getIndividualLendingCommandDispatcher();
}
