// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocS3.ibd;

import com.airbus.pocS3.definitions.IProfileService;

import org.eclipse.e4.core.di.annotations.Execute;

/**
 *
 */
public class IbdProcessor {

    @Execute
    public void execute(IProfileService profileService) {
        // final IProfile IBD_profile = ProfileFactory.createProfile("IBD profile", Collections.emptyList());
        // profileService.addProfile(IBD_profile);
    }

//    @Inject
//    @Optional
//    public void updateToolbarControls(@UIEventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) HashMap<?, ?> event, EModelService modelService,
//        MApplication application) {
//        System.out.println("event "+event);
//        event.forEach((key, value) -> System.out.println("key="+key+"   " +value));
////        final Object newValue = (Object) event.getProperty(EventTags.NEW_VALUE);
//    }

//    @Inject
//    @Optional
//    public void updateToolbarControls(@UIEventTopic(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) org.osgi.service.event.Event event) {
//        System.out.println("event "+event);
//        final Object newValue = event.getProperty(EventTags.NEW_VALUE);
//
//        if (newValue instanceof MPerspective) {
//            final MPerspective perspective = (MPerspective) newValue;
//        }
//    }

//    @Inject
//    @Optional
//    public void event(@UIEventTopic(UIEvents.UILifeCycle.BRINGTOTOP) Object o, EModelService modelService,
//        MApplication application) {
//        System.out.println("event "+o);
////        event.forEach((key, value) -> System.out.println("key="+key+"   " +value));
////        final Object newValue = (Object) event.getProperty(EventTags.NEW_VALUE);
//    }



    // @Inject
    // public void setPerspective(@Optional MPerspective perspective) {
    // System.err.println("TODO "+perspective);
    // }

//    @Inject
//    void setPerspective(@Optional @Named(PocS3_Constants.POCS3_ACTIVE_PERSPECTIVE_ID) String perspectiveId, MApplication application,
//        EModelService modelService, EMenuService menuService, EPartService partService) {
//        final boolean activate = Ibd_Constants.IBD_PERSPECTIVE_ID.equals(perspectiveId);
//
//
//
//        final MMenuElement ibd_menu = (MMenuElement) modelService.find(Ibd_Constants.IBD_MENU_ID, application);
//        System.out.println("ibd_menu " + ibd_menu);
//        if (activate) {
//            if (ibd_menu == null) {
////                ibd_menu = modelService.createModelElement(MMenuElement.class);
////                ibd_menu.s
//            }
//            ibd_menu.setVisible(activate);
//        } else {
//            if (ibd_menu != null) {
//                ibd_menu.setVisible(activate);
//            }
//        }
//
//        // System.err.println("TODO "+perspectiveId);
//        // if () {
//        // System.err.println("Must activate");
//        // } else {
//        // System.err.println("Must deactivate");
//        // }
//    }

}
