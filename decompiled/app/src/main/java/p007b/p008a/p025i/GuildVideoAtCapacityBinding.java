package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.z, reason: use source file name */
/* JADX INFO: compiled from: GuildVideoAtCapacityBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class GuildVideoAtCapacityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1431a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1432b;

    public GuildVideoAtCapacityBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.f1431a = linearLayout;
        this.f1432b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1431a;
    }
}
