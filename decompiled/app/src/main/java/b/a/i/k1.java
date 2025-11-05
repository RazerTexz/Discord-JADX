package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ServerSettingsMembersRoleSpinnerItemBinding.java */
/* loaded from: classes.dex */
public final class k1 implements ViewBinding {

    @NonNull
    public final TextView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f145b;

    public k1(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f145b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
