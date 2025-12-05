package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* compiled from: ViewServerSettingsNotificationsBinding.java */
/* renamed from: b.a.i.k3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerSettingsNotificationsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1001a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f1002b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f1003c;

    public ViewServerSettingsNotificationsBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2) {
        this.f1001a = linearLayout;
        this.f1002b = checkedSetting;
        this.f1003c = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1001a;
    }
}
