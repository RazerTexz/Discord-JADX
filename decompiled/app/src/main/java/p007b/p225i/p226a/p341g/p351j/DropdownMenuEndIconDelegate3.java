package p007b.p225i.p226a.p341g.p351j;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* renamed from: b.i.a.g.j.j, reason: use source file name */
/* loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate3 implements View.OnTouchListener {

    /* renamed from: j */
    public final /* synthetic */ AutoCompleteTextView f11815j;

    /* renamed from: k */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11816k;

    public DropdownMenuEndIconDelegate3(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        this.f11816k = dropdownMenuEndIconDelegate;
        this.f11815j = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f11816k.m6156i()) {
                this.f11816k.f11796i = false;
            }
            DropdownMenuEndIconDelegate.m6153g(this.f11816k, this.f11815j);
        }
        return false;
    }
}
