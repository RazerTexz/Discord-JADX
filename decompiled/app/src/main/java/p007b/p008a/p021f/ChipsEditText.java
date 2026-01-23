package p007b.p008a.p021f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.f.d, reason: use source file name */
/* JADX INFO: compiled from: ChipsEditText.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class ChipsEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: j */
    public final a f617j;

    /* JADX INFO: renamed from: b.a.f.d$a */
    /* JADX INFO: compiled from: ChipsEditText.kt */
    public interface a {
        /* JADX INFO: renamed from: a */
        InputConnection mo187a(InputConnection inputConnection);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsEditText(Context context, a aVar) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(aVar, "mInputConnectionWrapperInterface");
        this.f617j = aVar;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Intrinsics3.checkNotNullParameter(editorInfo, "outAttrs");
        return this.f617j.mo187a(super.onCreateInputConnection(editorInfo));
    }
}
