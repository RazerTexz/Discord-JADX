package b.a.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import d0.z.d.m;

/* compiled from: ChipsEditText.kt */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class d extends AppCompatEditText {
    public final a j;

    /* compiled from: ChipsEditText.kt */
    public interface a {
        InputConnection a(InputConnection inputConnection);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, a aVar) {
        super(context);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(aVar, "mInputConnectionWrapperInterface");
        this.j = aVar;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        m.checkNotNullParameter(editorInfo, "outAttrs");
        return this.j.a(super.onCreateInputConnection(editorInfo));
    }
}
