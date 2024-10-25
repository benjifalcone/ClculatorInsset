/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.Messages;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageServiceAsync;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author user
 */
public final class PourcentagePresenter extends Composite {

    @UiField
    public ResetButton boutonClear;
    @UiField
    public ResetButton boutonClearB;
    @UiField
    public SubmitButton boutonEnregistrer;
    @UiField
    public SubmitButton boutonDiv;
    @UiField
    public TextBox porce;
    @UiField
    public TextBox valA;
    @UiField
    public TextBox valB;
    @UiField
    public Label errorLabel;
    @UiField
    public Label errorLabelRToA;

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    
    private final PourcentageServiceAsync service = GWT.create(PourcentageService.class);

    private final Messages messages = GWT.create(Messages.class);

    interface MyUiBinder extends UiBinder<HTMLPanel, PourcentagePresenter> {
    }

    /**
     * Create UiBinder for the view
     */
    private static final MyUiBinder ourUiBinder = GWT.create(MyUiBinder.class);

    /**
     * Constructeur
     */
    public PourcentagePresenter() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Methode qui innitialise les handler pour les cliques sur les boutons
     */
    protected void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                porce.setText("");
                errorLabelRToA.setText("");
            }
        });
        boutonClearB.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                porce.setText("");
                errorLabel.setText("");
            }
        });
        boutonEnregistrer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                division();
            }
        });
        boutonDiv.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valA.setText("");
                valB.setText("");
                errorLabelRToA.setText("");
            }
        });
    }

    private void division() {
        service.division ((Integer.parseInt(valA.getText())), (Integer.parseInt(valB.getText())),  new AsyncCallback<Integer>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
//                Window.alert(SERVER_ERROR);
            }

            public void onSuccess(Integer result) {
                errorLabelRToA.setText(" ");
                new DialogBoxInssetPresenter("Resultat division", valA.getText(), String.valueOf(result));
            }
        });
    }
}