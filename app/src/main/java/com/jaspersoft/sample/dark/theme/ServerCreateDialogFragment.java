package com.jaspersoft.sample.dark.theme;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ServerCreateDialogFragment extends DialogFragment {
    public static final String TAG = ServerCreateDialogFragment.class.getSimpleName();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View form = LayoutInflater.from(getActivity()).inflate(R.layout.server_create_form, null);
        final EditText serverName = (EditText) form.findViewById(R.id.serverName);
        final EditText serverUrl = (EditText) form.findViewById(R.id.serverUrl);
        final EditText username = (EditText) form.findViewById(R.id.username);
        final EditText password = (EditText) form.findViewById(R.id.password);

        builder.setView(form);
        builder.setTitle("Create new Server Profile");
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setNegativeButton(android.R.string.cancel, null);

        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        boolean valid = true;
                        valid &= validateInputNotEmpty(serverName, "Server name can`t be empty");
                        valid &= validateInputNotEmpty(serverUrl, "Server URL can`t be empty");
                        valid &= validateInputNotEmpty(username, "User name can`t be empty");
                        valid &= validateInputNotEmpty(password, "Password can`t be empty");

                        if (valid) dismiss();
                    }
                });
            }
        });

        return dialog;
    }

    private boolean validateInputNotEmpty(EditText editText, String message) {
        String text = editText.getText().toString();
        if (TextUtils.isEmpty(text)) {
            editText.setError(message);
            return false;
        }
        return true;
    }

    public static void show(FragmentManager fragmentManager) {
        ServerCreateDialogFragment dialogFragment = (ServerCreateDialogFragment)
                fragmentManager.findFragmentByTag(TAG);

        if (dialogFragment == null) {
            dialogFragment = new ServerCreateDialogFragment();
            dialogFragment.show(fragmentManager, TAG);
        }
    }
}
