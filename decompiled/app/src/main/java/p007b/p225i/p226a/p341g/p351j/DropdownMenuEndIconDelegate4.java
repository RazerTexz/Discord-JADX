package p007b.p225i.p226a.p341g.p351j;

import android.widget.AutoCompleteTextView;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* renamed from: b.i.a.g.j.k, reason: use source file name */
/* loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate4 implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11817a;

    public DropdownMenuEndIconDelegate4(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11817a = dropdownMenuEndIconDelegate;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.f11817a;
        dropdownMenuEndIconDelegate.f11796i = true;
        dropdownMenuEndIconDelegate.f11798k = System.currentTimeMillis();
        DropdownMenuEndIconDelegate.m6152f(this.f11817a, false);
    }
}
