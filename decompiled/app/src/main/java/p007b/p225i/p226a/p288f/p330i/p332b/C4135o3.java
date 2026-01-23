package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.f.i.b.o3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4135o3 extends AbstractC4170r5 {

    /* JADX INFO: renamed from: c */
    public static final AtomicReference<String[]> f11001c = new AtomicReference<>();

    /* JADX INFO: renamed from: d */
    public static final AtomicReference<String[]> f11002d = new AtomicReference<>();

    /* JADX INFO: renamed from: e */
    public static final AtomicReference<String[]> f11003e = new AtomicReference<>();

    public C4135o3(C4202u4 c4202u4) {
        super(c4202u4);
    }

    @Nullable
    /* JADX INFO: renamed from: v */
    public static String m5763v(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Objects.requireNonNull(atomicReference, "null reference");
        AnimatableValueParser.m539l(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (C4196t9.m5884q0(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    /* JADX INFO: renamed from: r */
    public final boolean mo5574r() {
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: s */
    public final String m5764s(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!m5770z()) {
            return bundle.toString();
        }
        StringBuilder sbM833U = outline.m833U("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbM833U.length() != 8) {
                sbM833U.append(", ");
            }
            sbM833U.append(m5768x(str));
            sbM833U.append("=");
            Object obj = bundle.get(str);
            sbM833U.append(obj instanceof Bundle ? m5767w(new Object[]{obj}) : obj instanceof Object[] ? m5767w((Object[]) obj) : obj instanceof ArrayList ? m5767w(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbM833U.append("}]");
        return sbM833U.toString();
    }

    @Nullable
    /* JADX INFO: renamed from: t */
    public final String m5765t(zzaq zzaqVar) {
        if (!m5770z()) {
            return zzaqVar.toString();
        }
        StringBuilder sbM833U = outline.m833U("origin=");
        sbM833U.append(zzaqVar.f20668l);
        sbM833U.append(",name=");
        sbM833U.append(m5766u(zzaqVar.f20666j));
        sbM833U.append(",params=");
        zzap zzapVar = zzaqVar.f20667k;
        sbM833U.append(zzapVar == null ? null : !m5770z() ? zzapVar.toString() : m5764s(zzapVar.m9114x0()));
        return sbM833U.toString();
    }

    @Nullable
    /* JADX INFO: renamed from: u */
    public final String m5766u(String str) {
        if (str == null) {
            return null;
        }
        return !m5770z() ? str : m5763v(str, C4214v5.f11306c, C4214v5.f11304a, f11001c);
    }

    @Nullable
    /* JADX INFO: renamed from: w */
    public final String m5767w(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sbM833U = outline.m833U("[");
        for (Object obj : objArr) {
            String strM5764s = obj instanceof Bundle ? m5764s((Bundle) obj) : String.valueOf(obj);
            if (strM5764s != null) {
                if (sbM833U.length() != 1) {
                    sbM833U.append(", ");
                }
                sbM833U.append(strM5764s);
            }
        }
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Nullable
    /* JADX INFO: renamed from: x */
    public final String m5768x(String str) {
        if (str == null) {
            return null;
        }
        return !m5770z() ? str : m5763v(str, C4203u5.f11280b, C4203u5.f11279a, f11002d);
    }

    @Nullable
    /* JADX INFO: renamed from: y */
    public final String m5769y(String str) {
        if (str == null) {
            return null;
        }
        if (!m5770z()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m5763v(str, C4236x5.f11342b, C4236x5.f11341a, f11003e);
        }
        return "experiment_id(" + str + ")";
    }

    /* JADX INFO: renamed from: z */
    public final boolean m5770z() {
        return this.f11202a.m5951v() && this.f11202a.mo5726g().m5800x(3);
    }
}
