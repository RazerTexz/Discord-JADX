package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.m, reason: use source file name */
/* JADX INFO: compiled from: DirectoryChannelTabBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class DirectoryChannelTabBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f1038a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1039b;

    public DirectoryChannelTabBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f1038a = textView;
        this.f1039b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1038a;
    }
}
