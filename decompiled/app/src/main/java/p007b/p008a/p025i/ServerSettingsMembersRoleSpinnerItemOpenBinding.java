package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.l1, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsMembersRoleSpinnerItemOpenBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ServerSettingsMembersRoleSpinnerItemOpenBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f1017a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1018b;

    public ServerSettingsMembersRoleSpinnerItemOpenBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f1017a = textView;
        this.f1018b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1017a;
    }
}
