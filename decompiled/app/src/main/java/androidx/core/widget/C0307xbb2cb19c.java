package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function1;

/* compiled from: TextView.kt */
/* renamed from: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 */
/* loaded from: classes.dex */
public final class C0307xbb2cb19c implements TextWatcher {
    public final /* synthetic */ Function1 $afterTextChanged;

    public C0307xbb2cb19c(Function1 function1) {
        this.$afterTextChanged = function1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        this.$afterTextChanged.invoke(s2);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
