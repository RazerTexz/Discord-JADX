package p007b.p008a.p059w;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeTokens.kt */
/* renamed from: b.a.w.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class TypeTokens {

    /* renamed from: a */
    public static final Type f2003a;

    /* compiled from: TypeTokens.kt */
    /* renamed from: b.a.w.a$a */
    public static final class a extends TypeToken<List<? extends String>> {
    }

    static {
        Type type = new a().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "object : TypeToken<List<String>>() {}.type");
        f2003a = type;
    }
}
