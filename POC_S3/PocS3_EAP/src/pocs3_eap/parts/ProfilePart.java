
package pocs3_eap.parts;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pocs3_eap.layout.CenterRowLayout;
import pocs3_eap.parts.internal.PocS3EapController;
import pocs3_service_definitions.IProfile;
import pocs3_service_definitions.IProfileService;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 *
 */
public class ProfilePart {
    @Inject
    private PocS3EapController eapController;

    private Combo combo;
    private IProfile[] profiles;

    @PostConstruct
    public void createComposite(Composite parent, IProfileService profileService) {

        parent.setLayout(new CenterRowLayout());

        final Composite content = new Composite(parent, SWT.NONE);
        content.setLayout(new GridLayout(2, false));

        new Label(content, SWT.NONE).setText("Select profile");
        this.combo = new Combo(content, SWT.READ_ONLY);

        final Set<IProfile> profileSet = profileService.getProfiles();
        this.profiles = profileSet.toArray(new IProfile[profileSet.size()]);
        this.combo.setItems(profileSet.stream().map(IProfile::getName).toArray(size -> new String[size]));
        this.combo.select(0);

        //
        // final Button addProfileButton = new Button(content, SWT.FLAT);
        // addProfileButton.setText("add temp profile");
        // addProfileButton.addSelectionListener(new SelectionListener() {
        //
        // @Override
        // public void widgetSelected(SelectionEvent e) {
        // final IProfile profile = ProfileFactory.build("profile " + UUID.randomUUID().toString().substring(0, 5), Collections.emptyList());
        // profileService.addProfile(profile);
        // }
        //
        // @Override
        // public void widgetDefaultSelected(SelectionEvent e) {}
        // });

        final Button selectProfileButton = new Button(content, SWT.FLAT);
        selectProfileButton.setText("Select profile");
        selectProfileButton.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                final IProfile selectedProfile = ProfilePart.this.profiles[ProfilePart.this.combo.getSelectionIndex()];

                ProfilePart.this.eapController.switchToApplicationBoardPerspective(selectedProfile);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {}
        });
        final GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1);
        gridData.verticalIndent = 50;
        selectProfileButton.setLayoutData(gridData);
    }

    @Focus
    public void onFocus() {
        this.combo.setFocus();
    }

    @Inject
    @Optional
    public void receiveEvent(@UIEventTopic(IProfileService.PROFILE_ADDED) IProfile profile, IProfileService profileService) {
        System.out.println("receiveEvent " + profile);

        if (this.combo != null) {
            final int index = this.combo.getSelectionIndex();

            final Set<IProfile> profileSet = profileService.getProfiles();
            this.profiles = profileSet.toArray(new IProfile[profileSet.size()]);
            this.combo.setItems(profileSet.stream().map(IProfile::getName).toArray(size -> new String[size]));
            this.combo.select(index);
            this.combo.getParent().layout();
        }
    }
}