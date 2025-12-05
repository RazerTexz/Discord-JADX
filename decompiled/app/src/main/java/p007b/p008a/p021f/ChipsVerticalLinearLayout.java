package p007b.p008a.p021f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ChipsVerticalLinearLayout.kt */
@SuppressLint({"ViewConstructor"})
/* renamed from: b.a.f.e, reason: use source file name */
/* loaded from: classes.dex */
public final class ChipsVerticalLinearLayout extends LinearLayout {

    /* renamed from: j */
    public final List<LinearLayout> f618j;

    /* renamed from: k */
    public final int f619k;

    /* compiled from: ChipsVerticalLinearLayout.kt */
    /* renamed from: b.a.f.e$a */
    public static final class a {

        /* renamed from: a */
        public int f620a;

        public a(int i, int i2) {
            this.f620a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsVerticalLinearLayout(Context context, int i) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.f619k = i;
        this.f618j = new ArrayList();
        setOrientation(1);
    }

    /* renamed from: a */
    public final LinearLayout m188a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f619k));
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setOrientation(0);
        addView(linearLayout);
        this.f618j.add(linearLayout);
        return linearLayout;
    }
}
