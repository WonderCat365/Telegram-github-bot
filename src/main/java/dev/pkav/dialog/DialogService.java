package dev.pkav.dialog;

import java.util.HashSet;
import java.util.Set;

public class DialogService {

    private final Set<Dialog> dialogs;

    public DialogService() {
        dialogs = new HashSet<Dialog>();
    }

    public boolean addDialog(Dialog dialog){
        return dialogs.add(dialog);
    }
}
