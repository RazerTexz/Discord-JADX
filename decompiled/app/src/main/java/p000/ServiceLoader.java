package p000;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.android.HandlerDispatcher;

/* compiled from: ServiceLoader */
/* renamed from: a, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class ServiceLoader {
    /* renamed from: a */
    public static Iterator m0a() {
        try {
            return Arrays.asList(new AndroidExceptionPreHandler()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    /* renamed from: b */
    public static Iterator m1b() {
        try {
            return Arrays.asList(new HandlerDispatcher()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
