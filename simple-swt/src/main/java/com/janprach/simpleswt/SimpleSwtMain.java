package com.janprach.simpleswt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SimpleSwtMain {

    public static void main(String[] args) {
            new SimpleSwtMain().swtHtmlHelloWorld();
    }

    public void swtHelloWorld() {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        final Button ok = new Button(shell, SWT.PUSH);
        ok.setText("Hello world!");
        ok.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                display.dispose();
            }
        });
        shell.setDefaultButton(ok);
        shell.setLayout(new RowLayout());
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    public void swtHtmlHelloWorld() {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setSize(800, 450);
        try {
            final Browser browser = new Browser(shell, SWT.NONE);
            // browser.setText("<html><body>Hello world!</body></html>");
            browser.setUrl("https://www.google.com");
            browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        } catch (final SWTError e) {
            final MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
            messageBox.setMessage("Browser cannot be initialized.");
            messageBox.setText("Exit");
            messageBox.open();
            System.exit(-1);
        }
        shell.setLayout(new GridLayout());
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

}
