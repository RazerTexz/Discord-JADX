package p007b.p225i.p226a.p341g.p351j;

import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.f, reason: use source file name */
/* JADX INFO: compiled from: CustomEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class CustomEndIconDelegate extends EndIconDelegate {
    public CustomEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // p007b.p225i.p226a.p341g.p351j.EndIconDelegate
    /* JADX INFO: renamed from: a */
    public void mo6146a() {
        this.f11819a.setEndIconOnClickListener(null);
        this.f11819a.setEndIconOnLongClickListener(null);
    }
}
