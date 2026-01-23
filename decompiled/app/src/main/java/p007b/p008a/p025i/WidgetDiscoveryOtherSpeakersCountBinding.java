package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.f5, reason: use source file name */
/* JADX INFO: compiled from: WidgetDiscoveryOtherSpeakersCountBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetDiscoveryOtherSpeakersCountBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f847a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f848b;

    public WidgetDiscoveryOtherSpeakersCountBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f847a = linearLayout;
        this.f848b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f847a;
    }
}
