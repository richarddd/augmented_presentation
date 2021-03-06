package se.chalmers.ocuclass.ui.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by richard on 13/10/15.
 */
public class ProgressDialogFragment extends AppCompatDialogFragment {


    private static final String EXTRA_MESSAGE = "extra_message";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    public static ProgressDialogFragment newInstance(String message){
        ProgressDialogFragment fragment = new ProgressDialogFragment();

        Bundle args = new Bundle();
        args.getString(EXTRA_MESSAGE, message);

        fragment.setArguments(args);

        return fragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String message = getArguments().getString(EXTRA_MESSAGE);


        ProgressDialog progressDialog = new ProgressDialog(getActivity(),getTheme());
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        return progressDialog;

    }

    @Override
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance())
            getDialog().setDismissMessage(null);
        super.onDestroyView();
    }


    public void setMessage(String message) {



        if(getDialog()!=null) {
            ((ProgressDialog)getDialog()).setMessage(message);
            return;
        }

        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE, message);
        this.setArguments(args);
    }
}
