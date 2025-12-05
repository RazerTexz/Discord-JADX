package p600f0.p601e0.p606h;

import java.io.IOException;
import java.net.ProtocolException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;

/* compiled from: StatusLine.kt */
/* renamed from: f0.e0.h.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class StatusLine {

    /* renamed from: a */
    public final Protocol2 f25544a;

    /* renamed from: b */
    public final int f25545b;

    /* renamed from: c */
    public final String f25546c;

    public StatusLine(Protocol2 protocol2, int i, String str) {
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        Intrinsics3.checkParameterIsNotNull(str, "message");
        this.f25544a = protocol2;
        this.f25545b = i;
        this.f25546c = str;
    }

    /* renamed from: a */
    public static final StatusLine m10234a(String str) throws IOException {
        String strSubstring;
        Protocol2 protocol2 = Protocol2.HTTP_1_0;
        Intrinsics3.checkParameterIsNotNull(str, "statusLine");
        int i = 9;
        if (StringsJVM.startsWith$default(str, "HTTP/1.", false, 2, null)) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(outline.m883w("Unexpected status line: ", str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException(outline.m883w("Unexpected status line: ", str));
                }
                protocol2 = Protocol2.HTTP_1_1;
            }
        } else {
            if (!StringsJVM.startsWith$default(str, "ICY ", false, 2, null)) {
                throw new ProtocolException(outline.m883w("Unexpected status line: ", str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException(outline.m883w("Unexpected status line: ", str));
        }
        try {
            String strSubstring2 = str.substring(i, i2);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i3 = Integer.parseInt(strSubstring2);
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException(outline.m883w("Unexpected status line: ", str));
                }
                strSubstring = str.substring(i + 4);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            return new StatusLine(protocol2, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(outline.m883w("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f25544a == Protocol2.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f25545b);
        sb.append(' ');
        sb.append(this.f25546c);
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
