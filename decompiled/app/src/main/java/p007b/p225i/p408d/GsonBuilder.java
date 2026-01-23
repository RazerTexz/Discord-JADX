package p007b.p225i.p408d;

import com.google.gson.DefaultDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.d.e, reason: use source file name */
/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonBuilder {

    /* JADX INFO: renamed from: a */
    public Excluder f13095a = Excluder.f21483j;

    /* JADX INFO: renamed from: b */
    public LongSerializationPolicy f13096b = LongSerializationPolicy.f13108j;

    /* JADX INFO: renamed from: c */
    public FieldNamingStrategy f13097c = FieldNamingPolicy.f13088j;

    /* JADX INFO: renamed from: d */
    public final Map<Type, InstanceCreator<?>> f13098d = new HashMap();

    /* JADX INFO: renamed from: e */
    public final List<TypeAdapterFactory2> f13099e = new ArrayList();

    /* JADX INFO: renamed from: f */
    public final List<TypeAdapterFactory2> f13100f = new ArrayList();

    /* JADX INFO: renamed from: g */
    public boolean f13101g = false;

    /* JADX INFO: renamed from: h */
    public int f13102h = 2;

    /* JADX INFO: renamed from: i */
    public int f13103i = 2;

    /* JADX INFO: renamed from: j */
    public boolean f13104j = true;

    /* JADX INFO: renamed from: a */
    public Gson m6851a() {
        ArrayList arrayList = new ArrayList(this.f13100f.size() + this.f13099e.size() + 3);
        arrayList.addAll(this.f13099e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f13100f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        int i = this.f13102h;
        int i2 = this.f13103i;
        if (i != 2 && i2 != 2) {
            DefaultDateTypeAdapter defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            TypeAdapter<Class> typeAdapter = TypeAdapters.f21582a;
            arrayList.add(new TypeAdapters.C1113932(Date.class, defaultDateTypeAdapter));
            arrayList.add(new TypeAdapters.C1113932(Timestamp.class, defaultDateTypeAdapter2));
            arrayList.add(new TypeAdapters.C1113932(java.sql.Date.class, defaultDateTypeAdapter3));
        }
        return new Gson(this.f13095a, this.f13097c, this.f13098d, this.f13101g, false, false, this.f13104j, false, false, false, this.f13096b, null, this.f13102h, this.f13103i, this.f13099e, this.f13100f, arrayList);
    }

    /* JADX INFO: renamed from: b */
    public GsonBuilder m6852b(Type type, Object obj) {
        boolean z2 = obj instanceof JsonSerializer2;
        C3404f.m4355w(z2 || (obj instanceof JsonDeserializer2) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.f13098d.put(type, (InstanceCreator) obj);
        }
        if (z2 || (obj instanceof JsonDeserializer2)) {
            TypeToken<?> typeToken = TypeToken.get(type);
            this.f13099e.add(new TreeTypeAdapter.SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null));
        }
        if (obj instanceof TypeAdapter) {
            List<TypeAdapterFactory2> list = this.f13099e;
            TypeAdapter<Class> typeAdapter = TypeAdapters.f21582a;
            list.add(new TypeAdapters.C1113831(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }
}
