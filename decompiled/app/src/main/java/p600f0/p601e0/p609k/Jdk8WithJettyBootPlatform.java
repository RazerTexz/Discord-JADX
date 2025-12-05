package p600f0.p601e0.p609k;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;

/* compiled from: Jdk8WithJettyBootPlatform.kt */
/* renamed from: f0.e0.k.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Jdk8WithJettyBootPlatform extends Platform2 {

    /* renamed from: d */
    public final Method f25770d;

    /* renamed from: e */
    public final Method f25771e;

    /* renamed from: f */
    public final Method f25772f;

    /* renamed from: g */
    public final Class<?> f25773g;

    /* renamed from: h */
    public final Class<?> f25774h;

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    /* renamed from: f0.e0.k.e$a */
    public static final class a implements InvocationHandler {

        /* renamed from: a */
        public boolean f25775a;

        /* renamed from: b */
        public String f25776b;

        /* renamed from: c */
        public final List<String> f25777c;

        public a(List<String> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            this.f25777c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Intrinsics3.checkParameterIsNotNull(obj, "proxy");
            Intrinsics3.checkParameterIsNotNull(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics3.areEqual(name, "supports") && Intrinsics3.areEqual(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (Intrinsics3.areEqual(name, "unsupported") && Intrinsics3.areEqual(Void.TYPE, returnType)) {
                this.f25775a = true;
                return null;
            }
            if (Intrinsics3.areEqual(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f25777c;
                }
            }
            if ((!Intrinsics3.areEqual(name, "selectProtocol") && !Intrinsics3.areEqual(name, "select")) || !Intrinsics3.areEqual(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!Intrinsics3.areEqual(name, "protocolSelected") && !Intrinsics3.areEqual(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj2 = objArr[0];
                if (obj2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                this.f25776b = (String) obj2;
                return null;
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
            }
            List list = (List) obj3;
            int size = list.size();
            if (size >= 0) {
                int i = 0;
                while (true) {
                    Object obj4 = list.get(i);
                    if (obj4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj4;
                    if (!this.f25777c.contains(str)) {
                        if (i == size) {
                            break;
                        }
                        i++;
                    } else {
                        this.f25776b = str;
                        return str;
                    }
                }
            }
            String str2 = this.f25777c.get(0);
            this.f25776b = str2;
            return str2;
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        Intrinsics3.checkParameterIsNotNull(method, "putMethod");
        Intrinsics3.checkParameterIsNotNull(method2, "getMethod");
        Intrinsics3.checkParameterIsNotNull(method3, "removeMethod");
        Intrinsics3.checkParameterIsNotNull(cls, "clientProviderClass");
        Intrinsics3.checkParameterIsNotNull(cls2, "serverProviderClass");
        this.f25770d = method;
        this.f25771e = method2;
        this.f25772f = method3;
        this.f25773g = cls;
        this.f25774h = cls2;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: a */
    public void mo10328a(SSLSocket sSLSocket) throws IllegalArgumentException {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            this.f25772f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) throws IllegalArgumentException {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Protocol2) next) != Protocol2.HTTP_1_0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Protocol2) it2.next()).toString());
        }
        try {
            this.f25770d.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform2.class.getClassLoader(), new Class[]{this.f25773g, this.f25774h}, new a(arrayList2)));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) throws IllegalArgumentException {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f25771e.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            boolean z2 = aVar.f25775a;
            if (!z2 && aVar.f25776b == null) {
                Platform2.m10329j(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (z2) {
                return null;
            }
            return aVar.f25776b;
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
