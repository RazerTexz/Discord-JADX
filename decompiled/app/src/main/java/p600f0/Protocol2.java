package p600f0;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Protocol.kt */
/* renamed from: f0.y, reason: use source file name */
/* loaded from: classes3.dex */
public enum Protocol2 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: q */
    public static final a f26062q = new a(null);
    private final String protocol;

    /* compiled from: Protocol.kt */
    /* renamed from: f0.y$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final Protocol2 m10423a(String str) throws IOException {
            Intrinsics3.checkParameterIsNotNull(str, "protocol");
            Protocol2 protocol2 = Protocol2.HTTP_1_0;
            if (!Intrinsics3.areEqual(str, Protocol2.m10422f(protocol2))) {
                protocol2 = Protocol2.HTTP_1_1;
                if (!Intrinsics3.areEqual(str, Protocol2.m10422f(protocol2))) {
                    protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
                    if (!Intrinsics3.areEqual(str, Protocol2.m10422f(protocol2))) {
                        protocol2 = Protocol2.HTTP_2;
                        if (!Intrinsics3.areEqual(str, Protocol2.m10422f(protocol2))) {
                            protocol2 = Protocol2.SPDY_3;
                            if (!Intrinsics3.areEqual(str, Protocol2.m10422f(protocol2))) {
                                protocol2 = Protocol2.QUIC;
                                if (!Intrinsics3.areEqual(str, Protocol2.m10422f(protocol2))) {
                                    throw new IOException(outline.m883w("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }
    }

    Protocol2(String str) {
        this.protocol = str;
    }

    /* renamed from: f */
    public static final /* synthetic */ String m10422f(Protocol2 protocol2) {
        return protocol2.protocol;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
