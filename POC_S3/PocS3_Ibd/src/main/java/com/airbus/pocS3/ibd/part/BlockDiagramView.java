// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocS3.ibd.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * The class <b>BlockDiagramView</b> allows to
 */
public class BlockDiagramView {
    @Inject
    public BlockDiagramView() {
    }

    @PostConstruct
    public void postConstruct(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        // temporary
        final TableViewer checkTableViewer = new TableViewer(parent, SWT.NONE);
        checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
        checkTableViewer.setInput(new String[] {"KA return", "Ibd1", "Ibd2"});
        checkTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
    }
}