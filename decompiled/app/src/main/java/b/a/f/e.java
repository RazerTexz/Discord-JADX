package b.a.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChipsVerticalLinearLayout.kt */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class e extends LinearLayout {
    public final List<LinearLayout> j;
    public final int k;

    /* compiled from: ChipsVerticalLinearLayout.kt */
    public static final class a {
        public int a;

        public a(int i, int i2) {
            this.a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i) {
        super(context);
        m.checkNotNullParameter(context, "context");
        this.k = i;
        this.j = new ArrayList();
        setOrientation(1);
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, this.k));
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setOrientation(0);
        addView(linearLayout);
        this.j.add(linearLayout);
        return linearLayout;
    }
}
