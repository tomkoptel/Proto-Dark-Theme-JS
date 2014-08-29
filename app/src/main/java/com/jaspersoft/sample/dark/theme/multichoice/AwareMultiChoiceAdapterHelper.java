package com.jaspersoft.sample.dark.theme.multichoice;

import android.app.Activity;
import android.view.ActionMode;
import android.widget.BaseAdapter;

import com.manuelpeinado.multichoiceadapter.MultiChoiceAdapterHelperBase;

import java.lang.reflect.Method;

public class AwareMultiChoiceAdapterHelper extends MultiChoiceAdapterHelperBase {
    private OnItemCheckedListener onCheckeditemCheckedListener;
    private ActionMode actionMode;

    protected AwareMultiChoiceAdapterHelper(BaseAdapter owner) {
        super(owner);
    }

    public void setItemChecked(long handle, boolean checked) {
        super.setItemChecked(handle, checked);
        if (onCheckeditemCheckedListener != null) {
            onCheckeditemCheckedListener.onItemChecked(handle, checked);
        }
    }

    public void setOnCheckeditemCheckedListener(OnItemCheckedListener onCheckeditemCheckedListener) {
        this.onCheckeditemCheckedListener = onCheckeditemCheckedListener;
    }

    @Override
    protected void startActionMode() {
        try {
            Activity activity = (Activity) adapterView.getContext();
            Method method = activity.getClass().getMethod("startActionMode", ActionMode.Callback.class);
            actionMode = (ActionMode) method.invoke(activity, owner);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void invalidateActionMode() {
       if (actionMode != null) {
           actionMode.invalidate();
       }
    }

    @Override
    public void finishActionMode() {
        if (actionMode != null) {
            actionMode.finish();
        }
    }

    @Override
    protected void setActionModeTitle(String title) {
        actionMode.setTitle(title);
    }

    @Override
    protected boolean isActionModeStarted() {
        return actionMode != null;
    }

    @Override
    protected void clearActionMode() {
        actionMode = null;
    }

    public static interface OnItemCheckedListener {
        void onItemChecked(long handle, boolean checked);
    }
}
