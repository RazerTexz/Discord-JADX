package p600f0.p601e0.p613n;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Call2;
import p600f0.Callback2;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.Exchange;
import p600f0.p601e0.p613n.RealWebSocket;

/* compiled from: RealWebSocket.kt */
/* renamed from: f0.e0.n.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealWebSocket2 implements Callback2 {

    /* renamed from: a */
    public final /* synthetic */ RealWebSocket f25859a;

    /* renamed from: b */
    public final /* synthetic */ Request f25860b;

    public RealWebSocket2(RealWebSocket realWebSocket, Request request) {
        this.f25859a = realWebSocket;
        this.f25860b = request;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e4 A[PHI: r15 r16
      0x00e4: PHI (r15v7 java.lang.Integer) = (r15v5 java.lang.Integer), (r15v5 java.lang.Integer), (r15v9 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x00e4: PHI (r16v10 java.lang.Integer) = (r16v5 java.lang.Integer), (r16v7 java.lang.Integer), (r16v5 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p600f0.Callback2
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo10358a(Call2 call2, Response response) {
        int iIntValue;
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Exchange exchange = response.exchange;
        try {
            this.f25859a.m10352h(response, exchange);
            RealWebSocket.c cVarM10170d = exchange.m10170d();
            Headers headers = response.headers;
            Intrinsics3.checkParameterIsNotNull(headers, "responseHeaders");
            int size = headers.size();
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            Integer intOrNull = null;
            Integer intOrNull2 = null;
            boolean z5 = false;
            while (i2 < size) {
                if (StringsJVM.equals(headers.m10955d(i2), "Sec-WebSocket-Extensions", true)) {
                    String strM10957g = headers.m10957g(i2);
                    int i3 = 0;
                    while (i3 < strM10957g.length()) {
                        int iM10127h = Util7.m10127h(strM10957g, ',', i3, i, 4);
                        int iM10125f = Util7.m10125f(strM10957g, ';', i3, iM10127h);
                        String strM10118C = Util7.m10118C(strM10957g, i3, iM10125f);
                        int i4 = iM10125f + 1;
                        if (StringsJVM.equals(strM10118C, "permessage-deflate", true)) {
                            if (z2) {
                                z5 = true;
                            }
                            while (i4 < iM10127h) {
                                int iM10125f2 = Util7.m10125f(strM10957g, ';', i4, iM10127h);
                                int iM10125f3 = Util7.m10125f(strM10957g, '=', i4, iM10125f2);
                                String strM10118C2 = Util7.m10118C(strM10957g, i4, iM10125f3);
                                String strRemoveSurrounding = iM10125f3 < iM10125f2 ? Strings4.removeSurrounding(Util7.m10118C(strM10957g, iM10125f3 + 1, iM10125f2), "\"") : null;
                                int i5 = iM10125f2 + 1;
                                if (StringsJVM.equals(strM10118C2, "client_max_window_bits", true)) {
                                    if (intOrNull != null) {
                                        z5 = true;
                                    }
                                    intOrNull = strRemoveSurrounding != null ? StringNumberConversions.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull == null) {
                                        z5 = true;
                                    }
                                } else if (StringsJVM.equals(strM10118C2, "client_no_context_takeover", true)) {
                                    if (z3) {
                                        z5 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z5 = true;
                                    }
                                    z3 = true;
                                } else if (StringsJVM.equals(strM10118C2, "server_max_window_bits", true)) {
                                    if (intOrNull2 != null) {
                                        z5 = true;
                                    }
                                    intOrNull2 = strRemoveSurrounding != null ? StringNumberConversions.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull2 == null) {
                                    }
                                } else if (StringsJVM.equals(strM10118C2, "server_no_context_takeover", true)) {
                                    if (z4) {
                                        z5 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z5 = true;
                                    }
                                    z4 = true;
                                }
                                i4 = i5;
                            }
                            i3 = i4;
                            z2 = true;
                        } else {
                            i3 = i4;
                            z5 = true;
                        }
                        i = 0;
                    }
                }
                i2++;
                i = 0;
            }
            this.f25859a.f25845y = new WebSocketExtensions(z2, intOrNull, z3, intOrNull2, z4, z5);
            if (!(!z5 && intOrNull == null && (intOrNull2 == null || (8 <= (iIntValue = intOrNull2.intValue()) && 15 >= iIntValue)))) {
                synchronized (this.f25859a) {
                    this.f25859a.f25831k.clear();
                    this.f25859a.mo10349e(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.f25859a.m10354j(Util7.f25403g + " WebSocket " + this.f25860b.url.m10406h(), cVarM10170d);
                RealWebSocket realWebSocket = this.f25859a;
                realWebSocket.f25842v.onOpen(realWebSocket, response);
                this.f25859a.m10355k();
            } catch (Exception e) {
                this.f25859a.m10353i(e, null);
            }
        } catch (IOException e2) {
            if (exchange != null) {
                exchange.m10167a(-1L, true, true, null);
            }
            this.f25859a.m10353i(e2, response);
            byte[] bArr = Util7.f25397a;
            Intrinsics3.checkParameterIsNotNull(response, "$this$closeQuietly");
            try {
                response.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    @Override // p600f0.Callback2
    /* renamed from: b */
    public void mo10359b(Call2 call2, IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(iOException, "e");
        this.f25859a.m10353i(iOException, null);
    }
}
