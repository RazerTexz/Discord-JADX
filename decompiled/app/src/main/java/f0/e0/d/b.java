package f0.e0.d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.g0.t;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import f0.c;
import f0.c0;
import f0.e0.h.e;
import f0.e0.k.h;
import f0.i;
import f0.s;
import f0.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.ByteString;

/* compiled from: JavaNetAuthenticator.kt */
/* loaded from: classes3.dex */
public final class b implements c {

    /* renamed from: b, reason: collision with root package name */
    public final s f3606b;

    public b(s sVar, int i) {
        s sVar2 = (i & 1) != 0 ? s.a : null;
        m.checkParameterIsNotNull(sVar2, "defaultDns");
        this.f3606b = sVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    @Override // f0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Request a(c0 c0Var, Response response) throws IOException {
        String str;
        List<i> listEmptyList;
        Proxy proxy;
        s sVar;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        Charset charsetForName;
        f0.a aVar;
        m.checkParameterIsNotNull(response, "response");
        Headers headers = response.headers;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        boolean z2 = true;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                listEmptyList = n.emptyList();
                Request request = response.request;
                w wVar = request.url;
                boolean z3 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407;
                if (c0Var != null || (proxy = c0Var.f3603b) == null) {
                    proxy = Proxy.NO_PROXY;
                }
                for (i iVar : listEmptyList) {
                    if (t.equals("Basic", iVar.f3671b, z2)) {
                        if (c0Var == null || (aVar = c0Var.a) == null || (sVar = aVar.d) == null) {
                            sVar = this.f3606b;
                        }
                        if (z3) {
                            SocketAddress socketAddressAddress = proxy.address();
                            if (socketAddressAddress == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                            }
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                            String hostName = inetSocketAddress.getHostName();
                            m.checkExpressionValueIsNotNull(proxy, "proxy");
                            try {
                                passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, wVar, sVar), inetSocketAddress.getPort(), wVar.d, iVar.a.get("realm"), iVar.f3671b, new URL(wVar.l), Authenticator.RequestorType.PROXY);
                            } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            String str2 = wVar.g;
                            m.checkExpressionValueIsNotNull(proxy, "proxy");
                            try {
                                passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str2, b(proxy, wVar, sVar), wVar.h, wVar.d, iVar.a.get("realm"), iVar.f3671b, new URL(wVar.l), Authenticator.RequestorType.SERVER);
                            } catch (MalformedURLException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        if (passwordAuthenticationRequestPasswordAuthentication != null) {
                            String str3 = z3 ? "Proxy-Authorization" : "Authorization";
                            String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                            m.checkExpressionValueIsNotNull(userName, "auth.userName");
                            char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                            m.checkExpressionValueIsNotNull(password, "auth.password");
                            String str4 = new String(password);
                            String str5 = iVar.a.get("charset");
                            if (str5 != null) {
                                try {
                                    charsetForName = Charset.forName(str5);
                                    m.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                                } catch (Exception unused) {
                                }
                            } else {
                                charsetForName = StandardCharsets.ISO_8859_1;
                                m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                            }
                            m.checkParameterIsNotNull(userName, "username");
                            m.checkParameterIsNotNull(str4, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                            m.checkParameterIsNotNull(charsetForName, "charset");
                            String strF = ByteString.INSTANCE.b(userName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str4, charsetForName).f();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Basic ");
                            sb.append(strF);
                            String string = sb.toString();
                            m.checkParameterIsNotNull(request, "request");
                            new LinkedHashMap();
                            w wVar2 = request.url;
                            String str6 = request.method;
                            RequestBody requestBody = request.body;
                            Map linkedHashMap = request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : h0.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                            Headers.a aVarE = request.headers.e();
                            m.checkParameterIsNotNull(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            m.checkParameterIsNotNull(string, "value");
                            m.checkParameterIsNotNull(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            m.checkParameterIsNotNull(string, "value");
                            Headers.Companion companion = Headers.INSTANCE;
                            companion.a(str3);
                            companion.b(string, str3);
                            aVarE.d(str3);
                            aVarE.b(str3, string);
                            if (wVar2 != null) {
                                return new Request(wVar2, str6, aVarE.c(), requestBody, f0.e0.c.A(linkedHashMap));
                            }
                            throw new IllegalStateException("url == null".toString());
                        }
                    }
                    z2 = true;
                }
                return null;
            }
            str = "Proxy-Authenticate";
        }
        String str7 = str;
        ByteString byteString = e.a;
        m.checkParameterIsNotNull(headers, "$this$parseChallenges");
        m.checkParameterIsNotNull(str7, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (t.equals(str7, headers.d(i2), true)) {
                g0.e eVar = new g0.e();
                eVar.b0(headers.g(i2));
                try {
                    e.b(eVar, arrayList);
                } catch (EOFException e3) {
                    h.a aVar2 = h.c;
                    h.a.i("Unable to parse challenge", 5, e3);
                }
            }
        }
        listEmptyList = arrayList;
        Request request2 = response.request;
        w wVar3 = request2.url;
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407) {
        }
        if (c0Var != null) {
            proxy = Proxy.NO_PROXY;
        }
        while (r0.hasNext()) {
        }
        return null;
    }

    public final InetAddress b(Proxy proxy, w wVar, s sVar) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && a.a[type.ordinal()] == 1) {
            return (InetAddress) u.first((List) sVar.a(wVar.g));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        m.checkExpressionValueIsNotNull(address, "(address() as InetSocketAddress).address");
        return address;
    }
}
