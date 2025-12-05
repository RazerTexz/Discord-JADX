package p007b.p008a.p021f;

import android.view.View;
import com.discord.chips_view.ChipsView;
import com.discord.chips_view.ChipsView.InterfaceC5465a;
import java.util.Objects;
import p007b.p008a.p021f.p022h.ViewChipDefaultBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Chip.kt */
/* renamed from: b.a.f.a */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0895a<K, T extends ChipsView.InterfaceC5465a> implements View.OnClickListener {

    /* renamed from: j */
    public ViewChipDefaultBinding f601j;

    /* renamed from: k */
    public boolean f602k;

    /* renamed from: l */
    public String f603l;

    /* renamed from: m */
    public String f604m;

    /* renamed from: n */
    public final K f605n;

    /* renamed from: o */
    public final T f606o;

    /* renamed from: p */
    public final a f607p;

    /* renamed from: q */
    public final ChipsView<K, T> f608q;

    /* compiled from: Chip.kt */
    /* renamed from: b.a.f.a$a */
    public static final class a {

        /* renamed from: a */
        public final int f609a;

        /* renamed from: b */
        public final int f610b;

        /* renamed from: c */
        public final int f611c;

        /* renamed from: d */
        public final int f612d;

        /* renamed from: e */
        public final int f613e;

        /* renamed from: f */
        public final int f614f;

        public a(int i, float f, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f609a = i;
            this.f610b = i2;
            this.f611c = i3;
            this.f612d = i4;
            this.f613e = i5;
            this.f614f = i8;
        }
    }

    public ViewOnClickListenerC0895a(String str, String str2, K k, T t, a aVar, ChipsView<K, T> chipsView) {
        Intrinsics3.checkNotNullParameter(aVar, "params");
        Intrinsics3.checkNotNullParameter(chipsView, "container");
        this.f603l = str;
        this.f604m = str2;
        this.f605n = k;
        this.f606o = t;
        this.f607p = aVar;
        this.f608q = chipsView;
        String strSubstring = null;
        if (str == null) {
            this.f603l = t != null ? t.getDisplayString() : null;
        }
        String str3 = this.f603l;
        if ((str3 != null ? str3.length() : 0) > 30) {
            String str4 = this.f603l;
            if (str4 != null) {
                strSubstring = str4.substring(0, 30);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.f603l = Intrinsics3.stringPlus(strSubstring, "...");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof ViewOnClickListenerC0895a) {
            return Intrinsics3.areEqual(this.f606o, ((ViewOnClickListenerC0895a) obj).f606o);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f603l;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f604m;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        K k = this.f605n;
        int iHashCode3 = (iHashCode2 + (k != null ? k.hashCode() : 0)) * 31;
        T t = this.f606o;
        int iHashCode4 = (this.f608q.hashCode() + ((this.f607p.hashCode() + ((iHashCode3 + (t != null ? t.hashCode() : 0)) * 31)) * 31)) * 31;
        ViewChipDefaultBinding viewChipDefaultBinding = this.f601j;
        return C0897c.m186a(this.f602k) + ((iHashCode4 + (viewChipDefaultBinding != null ? viewChipDefaultBinding.hashCode() : 0)) * 31);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics3.checkNotNullParameter(view, "v");
        this.f608q.mEditText.clearFocus();
        ChipsView<K, T> chipsView = this.f608q;
        Objects.requireNonNull(chipsView);
        Intrinsics3.checkNotNullParameter(this, "chip");
        chipsView.m8380f(this);
        chipsView.m8379e(this);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("{[Data: ");
        sbM833U.append(this.f606o);
        sbM833U.append(']');
        sbM833U.append("[Label: ");
        sbM833U.append(this.f603l);
        sbM833U.append(']');
        sbM833U.append("[ImageDescription: ");
        sbM833U.append(this.f604m);
        sbM833U.append(']');
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
