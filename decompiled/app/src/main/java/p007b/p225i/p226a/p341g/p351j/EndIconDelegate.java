package p007b.p225i.p226a.p341g.p351j;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: EndIconDelegate.java */
/* renamed from: b.i.a.g.j.m, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class EndIconDelegate {

    /* renamed from: a */
    public TextInputLayout f11819a;

    /* renamed from: b */
    public Context f11820b;

    /* renamed from: c */
    public CheckableImageButton f11821c;

    public EndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        this.f11819a = textInputLayout;
        this.f11820b = textInputLayout.getContext();
        this.f11821c = textInputLayout.getEndIconView();
    }

    /* renamed from: a */
    public abstract void mo6146a();

    /* renamed from: b */
    public boolean mo6154b(int i) {
        return true;
    }

    /* renamed from: c */
    public void mo6147c(boolean z2) {
    }
}
