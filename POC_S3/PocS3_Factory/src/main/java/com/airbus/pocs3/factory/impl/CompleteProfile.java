
package com.airbus.pocs3.factory.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import com.airbus.pocS3.definitions.IProfile;
import com.airbus.pocS3.definitions.IProfileService;

/**
 * The class CompleteProfile allows to
 *
 * @Copyright Airbus 2017
 */
public class CompleteProfile implements IProfile {
  @Inject
  EModelService modelService;

  @Inject
  MApplication application;

  @Inject
  IProfileService profileService;

  @Override
  public String getName() {
    return "Complete";
  }

  @Override
  public List<String> getPerspectiveIds() {
    // // find all perspectives
    // final List<MPerspective> perspectives = this.modelService.findElements(this.application, null, MPerspective.class, null);
    //
    // final List<String> perspectiveNames = perspectives.stream()
    // .filter(perspective -> perspective.getTags().contains("Application")) // temporaire
    // .map(MPerspective::getElementId)
    // .collect(Collectors.toList());
    //
    // return perspectiveNames;

    return profileService.getProfiles().stream()
        .filter(profile -> profile != this)
        .flatMap(profile -> profile.getPerspectiveIds().stream())
        .distinct()
        .map(perspectiveId -> (MPerspective) modelService.find(perspectiveId, application))
        .filter(Objects::nonNull)
        .sorted(Comparator.comparing(MPerspective::getLabel))
        .map(MPerspective::getElementId)
        .collect(Collectors.toList())
        ;
  }

  @Override
  public String toString() {
    return "CompleteProfile";
  }
}