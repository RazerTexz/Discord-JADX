package p600f0.p601e0.p609k.p610i;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.OkHttpClient;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p608j.Http2;

/* compiled from: AndroidLog.kt */
/* renamed from: f0.e0.k.i.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class AndroidLog {

    /* renamed from: a */
    public static final CopyOnWriteArraySet<Logger> f25788a = new CopyOnWriteArraySet<>();

    /* renamed from: b */
    public static final Map<String, String> f25789b;

    /* renamed from: c */
    public static final AndroidLog f25790c = null;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = OkHttpClient.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        f25789b = Maps6.toMap(linkedHashMap);
    }
}
