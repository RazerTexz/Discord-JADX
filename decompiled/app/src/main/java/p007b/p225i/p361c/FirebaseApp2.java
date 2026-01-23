package p007b.p225i.p361c;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.badge.BadgeDrawable;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.ComponentCallbacks2C3281c;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;
import p007b.p225i.p226a.p288f.p299e.p308o.C3405g;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.ComponentRuntime4;
import p007b.p225i.p361c.p368l.EventBus;
import p007b.p225i.p361c.p368l.EventBus2;
import p007b.p225i.p361c.p368l.Lazy2;
import p007b.p225i.p361c.p396q.Event3;
import p007b.p225i.p361c.p396q.EventHandler2;
import p007b.p225i.p361c.p405v.DataCollectionConfigStorage;

/* JADX INFO: renamed from: b.i.c.c, reason: use source file name */
/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseApp2 {

    /* JADX INFO: renamed from: a */
    public static final Object f12115a = new Object();

    /* JADX INFO: renamed from: b */
    public static final Executor f12116b = new d(null);

    /* JADX INFO: renamed from: c */
    public static final Map<String, FirebaseApp2> f12117c = new ArrayMap();

    /* JADX INFO: renamed from: d */
    public final Context f12118d;

    /* JADX INFO: renamed from: e */
    public final String f12119e;

    /* JADX INFO: renamed from: f */
    public final FirebaseOptions f12120f;

    /* JADX INFO: renamed from: g */
    public final ComponentRuntime4 f12121g;

    /* JADX INFO: renamed from: j */
    public final Lazy2<DataCollectionConfigStorage> f12124j;

    /* JADX INFO: renamed from: h */
    public final AtomicBoolean f12122h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i */
    public final AtomicBoolean f12123i = new AtomicBoolean();

    /* JADX INFO: renamed from: k */
    public final List<b> f12125k = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b.i.c.c$b */
    /* JADX INFO: compiled from: FirebaseApp.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m6335a(boolean z2);
    }

    /* JADX INFO: renamed from: b.i.c.c$c */
    /* JADX INFO: compiled from: FirebaseApp.java */
    @TargetApi(14)
    public static class c implements ComponentCallbacks2C3281c.a {

        /* JADX INFO: renamed from: a */
        public static AtomicReference<c> f12126a = new AtomicReference<>();

        @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.ComponentCallbacks2C3281c.a
        /* JADX INFO: renamed from: a */
        public void mo4066a(boolean z2) {
            Object obj = FirebaseApp2.f12115a;
            synchronized (FirebaseApp2.f12115a) {
                for (FirebaseApp2 firebaseApp2 : new ArrayList(FirebaseApp2.f12117c.values())) {
                    if (firebaseApp2.f12122h.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator<b> it = firebaseApp2.f12125k.iterator();
                        while (it.hasNext()) {
                            it.next().m6335a(z2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.c.c$d */
    /* JADX INFO: compiled from: FirebaseApp.java */
    public static class d implements Executor {

        /* JADX INFO: renamed from: j */
        public static final Handler f12127j = new Handler(Looper.getMainLooper());

        public d(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            f12127j.post(runnable);
        }
    }

    /* JADX INFO: renamed from: b.i.c.c$e */
    /* JADX INFO: compiled from: FirebaseApp.java */
    @TargetApi(24)
    public static class e extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        public static AtomicReference<e> f12128a = new AtomicReference<>();

        /* JADX INFO: renamed from: b */
        public final Context f12129b;

        public e(Context context) {
            this.f12129b = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object obj = FirebaseApp2.f12115a;
            synchronized (FirebaseApp2.f12115a) {
                Iterator<FirebaseApp2> it = FirebaseApp2.f12117c.values().iterator();
                while (it.hasNext()) {
                    it.next().m6332d();
                }
            }
            this.f12129b.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FirebaseApp2(Context context, String str, FirebaseOptions firebaseOptions) {
        Bundle bundle;
        List<String> listEmptyList;
        PackageManager packageManager;
        new CopyOnWriteArrayList();
        this.f12118d = context;
        AnimatableValueParser.m583w(str);
        this.f12119e = str;
        Objects.requireNonNull(firebaseOptions, "null reference");
        this.f12120f = firebaseOptions;
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (packageManager == null) {
            Log.w("ComponentDiscovery", "Context has no PackageManager.");
        } else {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
            if (serviceInfo != null) {
                bundle = serviceInfo.metaData;
                if (bundle != null) {
                    Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : bundle.keySet()) {
                        if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                            arrayList.add(str2.substring(31));
                        }
                    }
                    listEmptyList = arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str3 : listEmptyList) {
                    try {
                        Class<?> cls = Class.forName(str3);
                        if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                            arrayList2.add((ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        } else {
                            Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str3, "com.google.firebase.components.ComponentRegistrar"));
                        }
                    } catch (ClassNotFoundException e2) {
                        Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str3), e2);
                    } catch (IllegalAccessException e3) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str3), e3);
                    } catch (InstantiationException e4) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str3), e4);
                    } catch (NoSuchMethodException e5) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str3), e5);
                    } catch (InvocationTargetException e6) {
                        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str3), e6);
                    }
                }
                arrayList2.add(new FirebaseCommonRegistrar());
                this.f12121g = new ComponentRuntime4(f12116b, arrayList2, Component4.m6349c(context, Context.class, new Class[0]), Component4.m6349c(this, FirebaseApp2.class, new Class[0]), Component4.m6349c(firebaseOptions, FirebaseOptions.class, new Class[0]));
                this.f12124j = new Lazy2<>(new FirebaseApp(this, context));
            }
            Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
        }
        bundle = null;
        if (bundle != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        while (r13.hasNext()) {
        }
        arrayList22.add(new FirebaseCommonRegistrar());
        this.f12121g = new ComponentRuntime4(f12116b, arrayList22, Component4.m6349c(context, Context.class, new Class[0]), Component4.m6349c(this, FirebaseApp2.class, new Class[0]), Component4.m6349c(firebaseOptions, FirebaseOptions.class, new Class[0]));
        this.f12124j = new Lazy2<>(new FirebaseApp(this, context));
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static FirebaseApp2 m6327b() {
        FirebaseApp2 firebaseApp2;
        synchronized (f12115a) {
            firebaseApp2 = f12117c.get("[DEFAULT]");
            if (firebaseApp2 == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + C3405g.m4370a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp2;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public static FirebaseApp2 m6328e(@NonNull Context context) {
        synchronized (f12115a) {
            if (f12117c.containsKey("[DEFAULT]")) {
                return m6327b();
            }
            FirebaseOptions firebaseOptionsM6337a = FirebaseOptions.m6337a(context);
            if (firebaseOptionsM6337a == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return m6329f(context, firebaseOptionsM6337a);
        }
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static FirebaseApp2 m6329f(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        FirebaseApp2 firebaseApp2;
        AtomicReference<c> atomicReference = c.f12126a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            if (c.f12126a.get() == null) {
                c cVar = new c();
                if (c.f12126a.compareAndSet(null, cVar)) {
                    ComponentCallbacks2C3281c.m4064a(application);
                    ComponentCallbacks2C3281c componentCallbacks2C3281c = ComponentCallbacks2C3281c.f9349j;
                    Objects.requireNonNull(componentCallbacks2C3281c);
                    synchronized (componentCallbacks2C3281c) {
                        componentCallbacks2C3281c.f9352m.add(cVar);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f12115a) {
            Map<String, FirebaseApp2> map = f12117c;
            AnimatableValueParser.m435G(!map.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            AnimatableValueParser.m595z(context, "Application context cannot be null.");
            firebaseApp2 = new FirebaseApp2(context, "[DEFAULT]", firebaseOptions);
            map.put("[DEFAULT]", firebaseApp2);
        }
        firebaseApp2.m6332d();
        return firebaseApp2;
    }

    /* JADX INFO: renamed from: a */
    public final void m6330a() {
        AnimatableValueParser.m435G(!this.f12123i.get(), "FirebaseApp was deleted");
    }

    /* JADX INFO: renamed from: c */
    public String m6331c() {
        StringBuilder sb = new StringBuilder();
        m6330a();
        byte[] bytes = this.f12119e.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        m6330a();
        byte[] bytes2 = this.f12120f.f12135b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    /* JADX INFO: renamed from: d */
    public final void m6332d() {
        Queue<Event3<?>> queue;
        Set<Map.Entry<EventHandler2<Object>, Executor>> setEmptySet;
        if (!UserManagerCompat.isUserUnlocked(this.f12118d)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            m6330a();
            sb.append(this.f12119e);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f12118d;
            if (e.f12128a.get() == null) {
                e eVar = new e(context);
                if (e.f12128a.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Device unlocked: initializing all Firebase APIs for app ");
        m6330a();
        sb2.append(this.f12119e);
        Log.i("FirebaseApp", sb2.toString());
        ComponentRuntime4 componentRuntime4 = this.f12121g;
        boolean zM6334h = m6334h();
        for (Map.Entry<Component4<?>, Lazy2<?>> entry : componentRuntime4.f12192b.entrySet()) {
            Component4<?> key = entry.getKey();
            Lazy2<?> value = entry.getValue();
            int i = key.f12177c;
            if (!(i == 1)) {
                if (!(i == 2) || !zM6334h) {
                }
            }
            value.get();
        }
        EventBus2 eventBus2 = componentRuntime4.f12195e;
        synchronized (eventBus2) {
            queue = eventBus2.f12207b;
            if (queue != null) {
                eventBus2.f12207b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event3<?> event3 : queue) {
                Objects.requireNonNull(event3);
                synchronized (eventBus2) {
                    Queue<Event3<?>> queue2 = eventBus2.f12207b;
                    if (queue2 != null) {
                        queue2.add(event3);
                    } else {
                        synchronized (eventBus2) {
                            ConcurrentHashMap<EventHandler2<Object>, Executor> concurrentHashMap = eventBus2.f12206a.get(null);
                            setEmptySet = concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
                        }
                        for (Map.Entry<EventHandler2<Object>, Executor> entry2 : setEmptySet) {
                            entry2.getValue().execute(new EventBus(entry2, event3));
                        }
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp2)) {
            return false;
        }
        String str = this.f12119e;
        FirebaseApp2 firebaseApp2 = (FirebaseApp2) obj;
        firebaseApp2.m6330a();
        return str.equals(firebaseApp2.f12119e);
    }

    /* JADX INFO: renamed from: g */
    public boolean m6333g() {
        boolean z2;
        m6330a();
        DataCollectionConfigStorage dataCollectionConfigStorage = this.f12124j.get();
        synchronized (dataCollectionConfigStorage) {
            z2 = dataCollectionConfigStorage.f13011d;
        }
        return z2;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: h */
    public boolean m6334h() {
        m6330a();
        return "[DEFAULT]".equals(this.f12119e);
    }

    public int hashCode() {
        return this.f12119e.hashCode();
    }

    public String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a(ModelAuditLogEntry.CHANGE_KEY_NAME, this.f12119e);
        c3361j.m4162a("options", this.f12120f);
        return c3361j.toString();
    }
}
