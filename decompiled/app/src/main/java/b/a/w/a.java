package b.a.w;

import com.google.gson.reflect.TypeToken;
import d0.z.d.m;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: TypeTokens.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final Type a;

    /* compiled from: TypeTokens.kt */
    /* renamed from: b.a.w.a$a, reason: collision with other inner class name */
    public static final class C0056a extends TypeToken<List<? extends String>> {
    }

    static {
        Type type = new C0056a().getType();
        m.checkNotNullExpressionValue(type, "object : TypeToken<List<String>>() {}.type");
        a = type;
    }
}
