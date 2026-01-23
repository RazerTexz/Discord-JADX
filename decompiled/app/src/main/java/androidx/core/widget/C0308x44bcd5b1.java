package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 */
/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0308x44bcd5b1 implements TextWatcher {
    public final /* synthetic */ Function4 $beforeTextChanged;

    public C0308x44bcd5b1(Function4 function4) {
        this.$beforeTextChanged = function4;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        this.$beforeTextChanged.invoke(text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
