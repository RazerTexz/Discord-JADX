package f0;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Protocol.kt */
/* loaded from: classes3.dex */
public enum y {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final a q = new a(null);
    private final String protocol;

    /* compiled from: Protocol.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final y a(String str) throws IOException {
            d0.z.d.m.checkParameterIsNotNull(str, "protocol");
            y yVar = y.HTTP_1_0;
            if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                yVar = y.HTTP_1_1;
                if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                    yVar = y.H2_PRIOR_KNOWLEDGE;
                    if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                        yVar = y.HTTP_2;
                        if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                            yVar = y.SPDY_3;
                            if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                                yVar = y.QUIC;
                                if (!d0.z.d.m.areEqual(str, y.f(yVar))) {
                                    throw new IOException(b.d.b.a.a.w("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return yVar;
        }
    }

    y(String str) {
        this.protocol = str;
    }

    public static final /* synthetic */ String f(y yVar) {
        return yVar.protocol;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
