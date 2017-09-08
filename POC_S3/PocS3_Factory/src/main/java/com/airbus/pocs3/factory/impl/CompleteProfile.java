
package com.airbus.pocs3.factory.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import com.airbus.pocS3.definitions.IApplication;
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
  public List<IApplication> getApplications() {
    return profileService.getProfiles().stream()
        .filter(profile -> profile != this)
        .flatMap(profile -> profile.getApplications().stream())
        .distinct()
        .sorted(Comparator.comparing(IApplication::getName))
        .collect(Collectors.toList())
        ;
  }

  @Override
  public String toString() {
    return "CompleteProfile";
  }
}