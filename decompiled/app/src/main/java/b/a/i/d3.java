package b.a.i;

import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewRadioButtonBinding.java */
/* loaded from: classes.dex */
public final class d3 implements ViewBinding {

    @NonNull
    public final RadioButton a;

    public d3(@NonNull RadioButton radioButton) {
        this.a = radioButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
