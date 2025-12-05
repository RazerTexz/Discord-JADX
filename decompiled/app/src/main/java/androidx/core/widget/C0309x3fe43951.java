package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function4;

/* compiled from: TextView.kt */
/* renamed from: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 */
/* loaded from: classes.dex */
public final class C0309x3fe43951 implements TextWatcher {
    public final /* synthetic */ Function4 $onTextChanged;

    public C0309x3fe43951(Function4 function4) {
        this.$onTextChanged = function4;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
        this.$onTextChanged.invoke(text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
    }
}
