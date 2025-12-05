package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MetadataBackendRegistry.java */
/* renamed from: b.i.a.b.j.q.k, reason: use source file name */
/* loaded from: classes3.dex */
public class MetadataBackendRegistry implements BackendRegistry {

    /* renamed from: a */
    public final a f5318a;

    /* renamed from: b */
    public final CreationContextFactory f5319b;

    /* renamed from: c */
    public final Map<String, TransportBackend> f5320c;

    /* compiled from: MetadataBackendRegistry.java */
    /* renamed from: b.i.a.b.j.q.k$a */
    public static class a {

        /* renamed from: a */
        public final Context f5321a;

        /* renamed from: b */
        public Map<String, String> f5322b = null;

        public a(Context context) {
            this.f5321a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        @Nullable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BackendFactory m2371a(String str) {
            Bundle bundle;
            Map<String, String> mapEmptyMap;
            PackageManager packageManager;
            if (this.f5322b == null) {
                Context context = this.f5321a;
                try {
                    packageManager = context.getPackageManager();
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.w("BackendRegistry", "Application info not found.");
                }
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                        if (bundle != null) {
                            Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                            mapEmptyMap = Collections.emptyMap();
                        } else {
                            HashMap map = new HashMap();
                            for (String str2 : bundle.keySet()) {
                                Object obj = bundle.get(str2);
                                if ((obj instanceof String) && str2.startsWith("backend:")) {
                                    for (String str3 : ((String) obj).split(",", -1)) {
                                        String strTrim = str3.trim();
                                        if (!strTrim.isEmpty()) {
                                            map.put(strTrim, str2.substring(8));
                                        }
                                    }
                                }
                            }
                            mapEmptyMap = map;
                        }
                        this.f5322b = mapEmptyMap;
                    }
                }
                bundle = null;
                if (bundle != null) {
                }
                this.f5322b = mapEmptyMap;
            }
            String str4 = this.f5322b.get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str4).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str4), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str4), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str4), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str4), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str4), e5);
                return null;
            }
        }
    }

    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        a aVar = new a(context);
        this.f5320c = new HashMap();
        this.f5318a = aVar;
        this.f5319b = creationContextFactory;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.BackendRegistry
    @Nullable
    public synchronized TransportBackend get(String str) {
        if (this.f5320c.containsKey(str)) {
            return this.f5320c.get(str);
        }
        BackendFactory backendFactoryM2371a = this.f5318a.m2371a(str);
        if (backendFactoryM2371a == null) {
            return null;
        }
        CreationContextFactory creationContextFactory = this.f5319b;
        TransportBackend transportBackendCreate = backendFactoryM2371a.create(new AutoValue_CreationContext(creationContextFactory.f5312a, creationContextFactory.f5313b, creationContextFactory.f5314c, str));
        this.f5320c.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
